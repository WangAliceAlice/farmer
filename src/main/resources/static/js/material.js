var app = new Vue({
    el: '#app',
    data: {
        activeIndex: '3',
        userType: null,
        username: null,
        dialogVisible: false,
        materials: null,
        purchaseRecords: null,
        form: {
            materialName: '',
            amount: 0,
            purchaseDate: null,
            remarks: ''
        },
        formLabelWidth: '120px'
    },
    methods: {
        logout: function () {
            this.$http.get('/logout').then(function () {
                window.location.href = '/login.html';
            })
        },
        createPurchaseRecord: function () {
            this.dialogVisible = false;
            var data = this.form;
            this.$http.post('/createPurchaseRecord', data).then(function (response) {
                console.log(response.body);
                var resp = response.body;
                this.$message({
                    type: 'success',
                    message: resp.msg
                });
                if (200 === resp.status) {
                    this.reloadDate();
                    this.clearForm();
                }
            });
        },
        reloadDate: function () {
            this.$http.get('/getAllMaterialsAndRecords').then(function (response) {
                var resp = response.body.obj;
                var mTemp = resp.materials;
                for (var i = 0; i < mTemp.length; i++) {
                    mTemp[i].price = mTemp[i].price / 100.0;
                }
                var pTemp = resp.purchaseRecords;
                for (var j = 0; j < pTemp.length; j++) {
                    pTemp[j].price = pTemp[j].price / 100.0;
                }
                this.purchaseRecords = pTemp;
                this.materials = mTemp;

            });
        },
        clearForm: function () {
            this.form.materialName = '';
            this.form.amount = 0;
            this.form.remarks = '';
            this.purchaseDate = null;
        },
        removeRecord: function (row) {
            var rId = row.rid;
            var _this = this;
            _this.$confirm('此操作将永久删除该记录,是否继续?', '提示', {
                confirmButtonText: '确定',
                cancelButtonText: '取消',
                type: 'warning'
            }).then(function () {
                _this.$http.post('/removeRecord', rId).then(function (value) {
                    var resp = value.body;
                    _this.$message({
                        type: 'success',
                        message: resp.msg
                    });
                    _this.reloadDate();
                })
            }).catch(function () {
                _this.$message({
                    type: 'info',
                    message: '已取消删除'
                });
            });
        }
    },
    created: function () {
        this.$http.get('/initUser').then(function (response) {
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
        this.reloadDate();
    }
});