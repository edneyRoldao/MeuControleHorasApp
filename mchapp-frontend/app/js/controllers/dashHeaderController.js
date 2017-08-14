/* EdneyRoldao - 07/08/17 */
function DashHeaderController(profile) {
	var ctrl = this;
	ctrl.profile = profile.data;
	ctrl.initials = ctrl.profile.name.substring(0,3).toUpperCase();
}

DashHeaderController.$inject = ["userProfile"];
angular.module("meuControleHorasApp").controller("DashHeaderController", DashHeaderController);