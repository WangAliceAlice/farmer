var app = new Vue({
    el: '#app',
    data: {
        activeIndex: '1',
        userType: null,
        username: null
    },
    methods: {
        logout: function () {
            this.$http.get('/logout').then(function () {
                window.location.href = '/login.html';
            })
        }
    },
    created: function () {          // 用户定制用户菜单
        this.$http.get('/initUser').then(function (response) {
            console.log(response);
            var resp = response.body;
            var _this = this;
            if (resp && resp.status === 200) {
                var user = resp.obj;
                _this.userType = user.userType;
                _this.username = user.username;
            } else {
                alert(resp.msg);
                window.location.href = '/login.html';
            }
        });
    }
});