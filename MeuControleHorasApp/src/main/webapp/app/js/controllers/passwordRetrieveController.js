// EdneyRoldao - 23/05/2017
function PasswordRetrieveController(userService, location) {
	var ctrl = this;
	
	ctrl.retrievePassword = function(email) {
		userService.retrievePassword(email).success(function(data) {
            swal("Senha Redefinida !", "Te enviamos um e-mail com uma nova senha !", "success");
			location.path("/login");

		}).error(function (data, status) {
            console.log("STATUS ERROR: " + status);

        });
	};

}

PasswordRetrieveController.$inject = ["UserService", "$location"];

angular.module("meuControleHorasApp").controller("PasswordRetrieveController", PasswordRetrieveController);