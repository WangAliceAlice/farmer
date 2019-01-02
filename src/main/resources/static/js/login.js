var app = new Vue({
    el: '#app',
    data: {
        message: '',
        username: 'guest',
        password: ''
    },
    methods: {
        submitClick: function () {
            var _this = this;
            var data = {
                username: _this.username,
                password: _this.password
            };
            this.$http.post('/login_p', {data: JSON.stringify(data)}).then(function (response) {
                var resp = response.body;
                this.message = resp.msg;
                if (resp && resp.status === 200) {
                    window.location.href = "/index.html";
                }
            })
        }
    }
});