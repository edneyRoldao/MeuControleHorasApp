// EdneyRoldao - 18/04/17
function NewUserController(UserAPIService) {
    var _ctrl = this;

    _ctrl.createUser = function(user) {

        delete user.passRepeat;
        console.log(user);

        UserAPIService.createUser(user).success(function(data) {
            console.log(data);
        }).error(function(status, data) {
            console.log(status);
            console.log(data);
        });
    };

}

angular.module("meuControleHorasApp").controller("UserController", NewUserController);