// EdneyRoldao - 27/06/2017
function DashboardController(profile, authenticationService) {
    var ctrl = this;

    ctrl.profile = profile.data;

    ctrl.logout = function () {
        authenticationService.logout();
    };

    ctrl.format = "HH:mm:ss  - dd/MM/yy";

    ctrl.picker2 = {
        date: new Date('2015-03-01T12:30:00Z'),
        timepickerOptions: {
            readonlyInput: false,
            showMeridian: false
        }
    };

    ctrl.openCalendar = function(e, picker) {
        ctrl[picker].open = true;
    };
}

DashboardController.$inject = ["userProfile", "AuthenticationService"];
angular.module("meuControleHorasApp").controller("DashboardController", DashboardController);