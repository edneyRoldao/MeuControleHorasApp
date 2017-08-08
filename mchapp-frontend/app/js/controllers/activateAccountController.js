// EdneyRoldao - 21/05/17
function ActivateAccountController(userService, state) {
    var ctrl = this;

    ctrl.activeAccount = function(serialCode) {

        userService.activateAccount(serialCode).success(function() {
            swal("Tudo certo !", "Usu\u00e1rio cadastrado com sucesso !", "success");
            state.go("home.login");

        }).error(function (data, status) {
            console.log("STATUS ERROR: " + status);

            ctrl.code = null;
            ctrl.activationForm.$setPristine();

            swal({
                title: "Falha na ativa\u00e7\u00e3o da conta!",
                text: "O c\u00f3digo de ativa\u00e7\u00e3o \u00e9 inv\u00e1lido ou o tempo expirou !",
                type: "warning",
                confirmButtonColor: "#D33",
                confirmButtonText: "OK",
                confirmButtonClass: "btn btn-danger"
            });

            state.go("home.ativarConta");
        });
    };

}

ActivateAccountController.$inject = ["UserService", "$state"];
angular.module("meuControleHorasApp").controller("ActivateAccountController", ActivateAccountController);