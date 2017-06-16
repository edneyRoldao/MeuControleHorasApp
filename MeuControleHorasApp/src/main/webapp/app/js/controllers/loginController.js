// Edney Roldao - 05/05/17
function LoginController(authenticationService) {
    var ctrl = this;

    ctrl.login = function (user) {
        user.username = user.email;
        delete user.email;

        authenticationService.createAuthToken(user).success(function (data) {
            authenticationService.login(data.token);
        	

        }).error(function (data, status) {
            console.log("STATUS ERROR: " + status);
            
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

LoginController.$inject = ["AuthenticationService"];
angular.module("meuControleHorasApp").controller("LoginController", LoginController);