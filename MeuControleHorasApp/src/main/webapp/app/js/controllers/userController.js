// EdneyRoldao - 18/04/17
function NewUserController(UserAPIService) {
    var ctrl = this;

    ctrl.users = [];

    var getAllUsers = function() {

        UserAPIService.getAllUsers()
            .success(function (data) {
                console.log(data);
                ctrl.users = data;
            })
            .error(function (status, data) {

            });
    };

    ctrl.getUsers = getAllUsers;

}

angular.module("meuControleHorasApp").controller("UserController", NewUserController);