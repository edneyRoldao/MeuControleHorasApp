/* EdneyRoldao - 07/08/17 */
function DashHeaderController(profile) {
	var ctrl = this;
	ctrl.profile = profile.data;
}

DashHeaderController.$inject = ["userProfile"];
angular.module("meuControleHorasApp").controller("DashHeaderController", DashHeaderController);