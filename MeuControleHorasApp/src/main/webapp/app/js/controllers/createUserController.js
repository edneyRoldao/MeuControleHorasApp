// EdneyRoldao - 18/04/17
function CreateUserController(userService, location) {
    var ctrl = this;

    ctrl.createUser = function(user) {

        var userObject = userService.buildUserObject(user);

        userService.createUser(userObject).success(function(data) {
            ctrl.newUserForm.$setPristine();
        	delete ctrl.user;

            swal("Estamos quase l\u00e1 !", "Te enviamos um e-mail com o um cdigo de ativa\u00e7\u00e3o da sua conta !", "success");
            location.path("/ativarConta");

        }).error(function(data, status) {
            console.log("STATUS ERROR: " + status);

            if(status === 409) {
                ctrl.user.password = null;
                ctrl.user.passRepeat = null;
                ctrl.newUserForm.$setPristine();

                swal({
                    title: "Opa !",
                    text: "j\u00e1 existe um usu\u00e1rio com este e-mail cadastrado !",
                    type: "warning",
                    confirmButtonColor: "#D33",
                    confirmButtonText: "OK",
                    confirmButtonClass: "btn btn-danger"
                });

                location.path("/cadastro");
            }

        });
    };

}

CreateUserController.$inject = ["UserService", "$location"];
angular.module("meuControleHorasApp").controller("CreateUserController", CreateUserController);