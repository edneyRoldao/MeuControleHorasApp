// EdneyRoldao - 27/06/2017
function DashboardController(profile, authenticationService) {
    var ctrl = this;

    ctrl.profile = profile.data;

    ctrl.logout = function () {
        authenticationService.logout();
    };
}

DashboardController.$inject = ["userProfile", "AuthenticationService"];
angular.module("meuControleHorasApp").controller("DashboardController", DashboardController);