var app = new Vue({
    el: '#app',
    data: {
        activeIndex: '4',
        userType: null,
        username: null,
        dialogVisible: false,
        dialogIngredientVisible: false,
        dialogViewVisible: false,
        formLabelWidth: '120px',
        fertilizers: null,
        ingredients: null,
        ingredientsFromFertilizer: null,
        form: {
            fName: '',
            fDate: null,
            fee: 0,
            lossRate: 0,
            ingredients: []
        },
        ingredient: {
            ingredientName: '',
            amount: 0,
            id: null
        }
    },
    methods: {
        logout: function () {
            this.$http.get('/logout').then(function () {
                window.location.href = '/login.html';
            })
        },
        reloadDate: function () {
            this.$http.get('/getAllFertilizersAndIngredients').then(function (response) {
                var resp = response.body.obj;
                this.ingredients = resp.ingredients;
                this.fertilizers = resp.fertilizers;
                console.log(resp);
            })
        },
        clearForm: function () {
            this.form.fName = '';
            this.form.fDate = null;
            this.form.fee = 0;
            this.form.lossRate = 0;
            this.form.ingredients = [];
        },
        addIngredient: function () {
            for (var j = 0; j < this.form.ingredients.length; j++) {
                if (this.ingredient.id === this.form.ingredients[j].id) {
                    this.$message({
                        type: 'info',
                        message: '已添加该原料'
                    });
                    this.dialogIngredientVisible = false;
                    return;
                }
            }
            for (var i = 0; i < this.ingredients.length; i++) {
                if (this.ingredient.id === this.ingredients[i].id) {
                    this.ingredient.ingredientName = this.ingredients[i].ingredientName;
                    break;
                }
            }
            // 因为如果直接push的话, 是push this.ingredient的引用,会出现问题
            var temp = {
                ingredientName: this.ingredient.ingredientName,
                amount: this.ingredient.amount,
                id: this.ingredient.id
            };
            this.form.ingredients.push(temp);
            this.dialogIngredientVisible = false;
        },
        removeIngredient: function (index) {
            this.form.ingredients.splice(index, 1);
        },
        createFI: function () {
            this.dialogVisible = false;
            var data = this.form;
            this.$http.post('/createFI', data).then(function (response) {
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
        removeFI: function (row) {
            var fId = row.id;
            var _this = this;
            _this.$confirm('此操作将永久删除该记录,是否继续?', '提示', {
                confirmButtonText: '确定',
                cancelButtonText: '取消',
                type: 'warning'
            }).then(function () {
                _this.$http.post('/removeFI', fId).then(function (value) {
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
        },
        viewIngredient: function (row) {
            var _this = this;
            _this.ingredientsFromFertilizer = null;
            this.$http.post('/getIngredientsByFertilizer', row.id).then(function (value) {
                this.ingredientsFromFertilizer = value.body.obj;
                this.dialogViewVisible = true;
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
