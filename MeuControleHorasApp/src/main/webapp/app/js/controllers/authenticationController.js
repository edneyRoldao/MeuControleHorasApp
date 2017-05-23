// Edney Roldao - 05/05/17
function AuthenticationController(AuthAPIService) {
    var _ctrl = this;

    _ctrl.login = function (user) {
        user.username = user.email;
        delete user.email;

        AuthAPIService.createAuthToken(user).success(function (data) {

        }).error(function (data, status) {
            console.log("there was an error");
            console.log(status);
            
            // error message
            swal({
                title: "Opa !",
                text: "E-mail de usu\u00e1rio ou senha inv\u00e1lidos !",
                type: "warning",
                confirmButtonColor: "#D33",
                confirmButtonText: "OK",
                confirmButtonClass: "btn btn-danger"
            });

        });
    };

}

angular.module("meuControleHorasApp").controller("AuthController", AuthenticationController);