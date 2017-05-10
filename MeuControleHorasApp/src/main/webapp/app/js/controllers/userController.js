// EdneyRoldao - 18/04/17
function NewUserController(UserAPIService, $location) {
    var _ctrl = this;
    _ctrl.userAlreadyExists = false;

    _ctrl.createUser = function(user) {
    	
    	swal({
    		  title: "Auto close alert!",
    		  text: "I will close in 2 seconds.",
    		  type: "success",
    		  timer: 2000,
    		  showConfirmButton: false
    		});
    	
    	// http://t4t5.github.io/sweetalert/ documentation
    	
    	/*
        delete user.passRepeat;
        _ctrl.userAlreadyExists = false;        	

        UserAPIService.createUser(user).success(function(data) {
            _ctrl.newUserForm.$setPristine();
        	delete _ctrl.user;
            $location.path("/login");
            
        }).error(function(data, status) {
            console.log(status);
            _ctrl.userAlreadyExists = true;
            _ctrl.user.password = null;
            _ctrl.user.passRepeat = null;
            _ctrl.newUserForm.$setPristine();
            $location.path("/cadastro");
            
        });
        */
    };

}

angular.module("meuControleHorasApp").controller("UserController", NewUserController);