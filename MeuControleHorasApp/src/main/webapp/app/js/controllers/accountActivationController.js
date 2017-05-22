// EdneyRoldao - 21/05/17
function AccountActivationController(UserAPIService, $location) {
    var ctrl = this;

    ctrl.activeAccount = function(serialCode) {

        UserAPIService.activateAccount(serialCode).success(function(data) {
            console.log("success !");
            swal("Tudo certo !", "Usu\u00e1rio cadastrado com sucesso !", "success");
            $location.path("/login");

        }).error(function (data, status) {
            console.log(status);
            ctrl.code = null;
            ctrl.activationForm.$setPristine();

            // error message
            swal({
                title: "Falha na ativa\u00e7\u00e3o da conta!",
                text: "O c\u00f3digo de ativa\u00e7\u00e3o \u00e9 inv\u00e1lido ou o tempo expirou !",
                type: "warning",
                confirmButtonColor: "#D33",
                confirmButtonText: "OK",
                confirmButtonClass: "btn btn-danger"
            });

            $location.path("/activate");
        });

    };

}

angular.module("meuControleHorasApp").controller("AccountActivationController", AccountActivationController);