<html>
<script src="https://unpkg.com/vue"></script>
<script src="https://unpkg.com/axios@0.12.0/dist/axios.min.js"></script>

<body>
<div id="app">
    {{message}}
</div>
</body>
<script>
    var app = new Vue({
        el: '#app',
        data: {
            message: 'Hello Vue!'
        },
        created:function(){
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
