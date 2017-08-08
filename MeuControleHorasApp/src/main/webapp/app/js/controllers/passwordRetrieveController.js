// EdneyRoldao - 23/05/2017
function PasswordRetrieveController(userService, state) {
	var ctrl = this;
	
	ctrl.retrievePassword = function(email) {
		userService.retrievePassword(email).success(function() {
            swal("Senha Redefinida !", "Te enviamos um e-mail com uma nova senha !", "success");
            state.go("home.login");

		}).error(function (data, status) {
            console.log("STATUS ERROR: " + status);

        });
	};

}

PasswordRetrieveController.$inject = ["UserService", "$state"];
angular.module("meuControleHorasApp").controller("PasswordRetrieveController", PasswordRetrieveController);