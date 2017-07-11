<%@ page language="java" import="java.util.*" contentType="text/html; charset=GB2312" %>
<html>
<link rel="stylesheet" href="static/css/tree.css">
<script src="https://unpkg.com/vue"></script>
<script src="https://unpkg.com/vue-router/dist/vue-router.js"></script>
<script src="https://unpkg.com/axios@0.12.0/dist/axios.min.js"></script>
<script type="text/x-template" id="item-template">
    <li>
        <div :class="{bold: open}" @click="toggle">
            <span v-if="isFolder">
                {{open ? '-' : '+'}}
            </span>
            <template v-if="model.code">
                <router-link :to='model.code'> {{model.name}}</router-link>
            </template>
            <template v-else>
                {{model.name}}
            </template>

        </div>
        <ul v-show="open" v-if="isFolder">
            <tree class="item" v-for="model in model.children" :model="model">
            </tree>
        </ul>
    </li>
</script>

<body>
<div id="app" class="app">
    <div class="left">
        <ul>
            <tree class="item" :model="treeData"></tree>
        </ul>
    </div>
    <div class="right">
        <router-view></router-view>
    </div>
</div>
</body>


<%--Ê÷--%>
<script>
    Vue.component('tree', {
        template: '#item-template',
        props: {
            model: Object
        },
        data: function () {
            return {
                open: false
            }
        },
        computed: {
            isFolder: function () {
                return this.model.children &&
                    this.model.children.length
            }
        },
        methods: {
            toggle: function () {
                if (this.isFolder) {
                    this.open = !this.open
                }
            }
        }
    })


</script>

<script>
    const Grid = {template: '<div>grid</div>'}
    const Tree = {template: '<div>tree</div>'}
    const routes = [
        {path: '/grid', component: Grid},
        {path: '/tree', component: Tree}
    ]
    var app = new Vue({
        el: '#app',
        router: new VueRouter({
            routes: routes
        }),
        data: {
            message: 'Hello Vue!',
            treeData: {
                name: 'Vue demo',
                children: [
                    {name: 'ÁÐ±í', code: 'grid'},
                    {name: 'Ê÷',code:'tree'},
                ]
            }
        },
        created: function () {
            var vm = this
            axios.get('https://yesno.wtf/api')
                .then(function (response) {
                    vm.message = response.data.answer
                })
                .catch(function (error) {
                    vm.message = 'Error! Could not reach the API. ' + error
                })
        }
    })
</script>

</html>
