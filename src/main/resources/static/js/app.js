var app = new Vue({
    el: '#app',
    data: {
        userType: null,
        username: null
    },
    created: function () {          // 用户定制用户菜单
        this.$http.get('/test').then(function (response) {
            var user = response.body.data.obj;
            this.userType = user.userType;
            this.username = user.username;
            console.log(user);
        }, function (reason) {
            console.log(reason);
        });
    }
});