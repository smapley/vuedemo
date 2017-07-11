<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Eric
  Date: 2017/7/11
  Time: 11:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<link rel="stylesheet" href="static/css/demo.css">
<script src="https://unpkg.com/vue"></script>
<script src="https://unpkg.com/vue-router/dist/vue-router.js"></script>
<script src="https://unpkg.com/axios@0.12.0/dist/axios.min.js"></script>
<body>
<!-- demo root element -->
<div id="app">
    <grid>
    </grid>
</div>

<template id="grid-template">
    <div class="container">
        <button @click="openNewItemDialog('添加')">添加</button>
        <table>
            <thead>
            <tr>
                <th v-for="entity in columns"
                    @click="sortBy(entity.key)"
                    :class="{ active: sortKey == entity.key }">
                    {{ entity.value | capitalize }}
                    <span class="arrow" :class="sortOrders[entity.key] > 0 ? 'asc' : 'dsc'"></span>
                </th>
                <th>
                    操作
                </th>
            </tr>
            </thead>
            <tbody>
            <tr v-for="entry in filteredData">
                <td v-for="title in columns">
                    {{entry[title.key]}}
                </td>
                <td>
                    <button @click="openEditItemDialog(entry.id)">修改</button>
                    <button @click="deleteItem(entry.id)">删除</button>
                </td>
            </tr>
            </tbody>
        </table>
        <modal v-if="showAdd" @close="showAdd = false"
               :mode="mode"
               :title="title"
               :item="item">
            <div slot="body">
                <table class="form_table">
                    <tr>
                        <td><label>名称</label></td>
                        <td><input type="text" v-model="item['name']" /></td>
                    </tr>
                    <tr>
                        <td><label>作者</label></td>
                        <td><input type="text" v-model="item['author']" /></td>
                    </tr>
                </table>
            </div>
        </modal>
    </div>
</template>

<template id="modal-template">
    <transition name="modal">
        <div class="modal-mask">
            <div class="modal-wrapper">
                <div class="modal-container">
                    <div class="modal-header">
                        <slot name="header">{{ title }}</slot>
                    </div>
                    <div class="modal-body">
                        <slot name="body"></slot>
                    </div>
                    <div class="modal-footer">
                        <slot name="footer">
                            <button class="modal-default-button" @click="close()">取消</button>
                            <button class="modal-default-button" @click="save()">保存</button>
                        </slot>
                    </div>
                </div>
            </div>
        </div>
    </transition>
</template>


</body>

<script>
    Vue.component('modal', {
        template: '#modal-template',
        data: function () {
            return {}
        },
        props: ['mode', 'title', 'fields', 'item'],
        methods: {
            close: function () {
                this.$emit('close')
            },
            save: function () {
                var vm = this
                axios.post('book/save.do', this.item)
                    .then(function (response) {
                        vm.$emit('close');
                    })
                    .catch(function (error) {
                        alert('操作失败！');
                    })
            }
        }
    });

    Vue.component('grid', {
        template: '#grid-template',
        data: function () {
            var columns = [
                {key: 'name', value: '名称'},
                {key: 'author', value: '作者'}
            ];
            var sortOrders = {};
            columns.forEach(function (entity) {
                sortOrders[entity.key] = 1
            });
            return {
                columns: columns,
                data: [],
                sortKey: '',
                sortOrders: sortOrders,
                showAdd: false,
                mode: 0,
                title: '',
                item: {},
            }
        },
        watch: {
            showAdd: function (state) {
                if (!state) {
                    this.getData();
                }
            }
        },
        created: function () {
            this.getData();
        },
        computed: {
            filteredData: function () {
                var sortKey = this.sortKey;
                var filterKey = this.filterKey && this.filterKey.toLowerCase()
                var order = this.sortOrders[sortKey] || 1
                var data = this.data;
                if (filterKey) {
                    data = data.filter(function (row) {
                        return Object.keys(row).some(function (key) {
                            return String(row[key]).toLowerCase().indexOf(filterKey) > -1
                        })
                    })
                }
                if (sortKey) {
                    data = data.slice().sort(function (a, b) {
                        a = a[sortKey]
                        b = b[sortKey]
                        return (a === b ? 0 : a > b ? 1 : -1) * order
                    })
                }
                return data
            }
        },
        filters: {
            capitalize: function (str) {
                return str.charAt(0).toUpperCase() + str.slice(1)
            }
        },
        methods: {
            getData: function () {
                var vm = this
                axios.get('book/getList.do')
                    .then(function (response) {
                        vm.data = response.data.data;
                    });
            },
            sortBy: function (key) {
                this.sortKey = key
                this.sortOrders[key] = this.sortOrders[key] * -1
            },
            openNewItemDialog: function (title) {
                this.title = title;
                this.mode = 1;
                this.item = {};
                this.showAdd = true;
            },
            openEditItemDialog: function (key) {
                debugger
                var currentItem = this.findItemByKey(key)
                this.title = '修改 - ' + key
                this.mode = 2;
                this.item = this.initItemForUpdate(currentItem)
                this.showAdd = true;
            },
            deleteItem: function (key) {
                var vm = this;
                axios.post('book/delete.do', {
                    id: key
                }).then(function () {
                    vm.getData();
                })
                    .catch(function (error) {
                        alert('操作失败！');
                    })
            }
        }
    });


    // bootstrap the demo
    var app = new Vue({
        el: '#app',
        data: {}

    })
</script>
</html>
