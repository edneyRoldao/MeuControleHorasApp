// Edney Roldao - 05/05/17
function AuthenticationController(AuthAPIService) {
    var _ctrl = this;

    _ctrl.login = function (user) {
        user.username = user.email;
        delete user.email;

        AuthAPIService.createAuthToken(user).success(function (data) {

            console.log("token has been created successfully");
            console.log(data);

        }).error(function (data, status) {

            console.log("there was an error");
            console.log(data);
            console.log(status);

        });
    };

}

angular.module("meuControleHorasApp").controller("AuthController", AuthenticationController);