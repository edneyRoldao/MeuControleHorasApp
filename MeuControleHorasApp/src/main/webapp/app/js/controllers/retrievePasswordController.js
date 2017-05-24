// EdneyRoldao - 23/05/2017
function RetrieveEmailController(UserAPIService, $location) {
	var ctrl = this;
	
	ctrl.retrievePassword = function(email) {
		UserAPIService.retrievePassword(email).success(function(data) {
            swal("Senha Redefinida !", "Te enviamos um e-mail com uma nova senha !", "success");
			$location.path("/login");

		}).error(function (data, status) {
            console.log("STATUS ERROR: " + status);

        });
		
	};

}

angular.module("meuControleHorasApp").controller("RetrieveEmailController", RetrieveEmailController);