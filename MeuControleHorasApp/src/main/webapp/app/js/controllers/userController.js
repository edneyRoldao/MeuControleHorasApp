// EdneyRoldao - 18/04/17
function NewUserController(UserAPIService, $location) {
    var _ctrl = this;
    _ctrl.userAlreadyExists = false;

    _ctrl.createUser = function(user) {
        delete user.passRepeat;
        _ctrl.userAlreadyExists = false;        	

        UserAPIService.createUser(user).success(function(data) {
            _ctrl.newUserForm.$setPristine();
        	delete _ctrl.user;

        	// Success message
            swal({
                title: "Sucesso !",
                text: "cadastro realizado",
                type: "success",
                timer: 3000,
                showConfirmButton: false
            });

            // Redirect
            $location.path("/login");
            
        }).error(function(data, status) {
            console.log(status);
            _ctrl.userAlreadyExists = true;
            _ctrl.user.password = null;
            _ctrl.user.passRepeat = null;
            _ctrl.newUserForm.$setPristine();
            $location.path("/cadastro");
            
        });
    };

}

angular.module("meuControleHorasApp").controller("UserController", NewUserController);