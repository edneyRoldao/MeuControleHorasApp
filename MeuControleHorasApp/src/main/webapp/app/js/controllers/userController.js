// EdneyRoldao - 18/04/17
function NewUserController(UserAPIService) {
    var _ctrl = this;

    _ctrl.createUser = function(user) {
        delete user.passRepeat;

        UserAPIService.createUser(user).success(function(data) {
            console.log(data);
        }).error(function(data, status) {
            console.log(status);
        });
    };

}

angular.module("meuControleHorasApp").controller("UserController", NewUserController);