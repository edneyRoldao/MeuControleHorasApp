// EdneyRoldao - 18/04/17
function NewUserController(UserAPIService, $location) {
    var _ctrl = this;

    _ctrl.createUser = function(user) {

        UserAPIService.createUser(user).success(function(data) {
            _ctrl.newUserForm.$setPristine();
        	delete _ctrl.user;

        	// Success message
            swal("Estamos quase l\u00e1 !", "Te enviamos um e-mail de ativa\u00e7\u00e3o da sua conta !", "success");

            // Redirect
            $location.path("/login");
            
        }).error(function(data, status) {
            console.log(status);
            _ctrl.user.password = null;
            _ctrl.user.passRepeat = null;
            _ctrl.newUserForm.$setPristine();

            // error message
            swal({
                title: "Opa !",
                text: "j\u00e1 existe um usu\u00e1rio com este e-mail cadastrado !",
                type: "warning",
                confirmButtonColor: "#D33",
                confirmButtonText: "OK",
                confirmButtonClass: "btn btn-danger"
            });

            $location.path("/cadastro");
        });
    };

}

angular.module("meuControleHorasApp").controller("UserController", NewUserController);