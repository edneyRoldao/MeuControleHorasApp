/* EdneyRoldao - 07/08/17 */
function DashHeaderController(profile) {
	var ctrl = this;
	ctrl.profile = profile.data;
    console.log(ctrl.profile);
}

DashHeaderController.$inject = ["userProfile"];
angular.module("meuControleHorasApp").controller("DashHeaderController", DashHeaderController);