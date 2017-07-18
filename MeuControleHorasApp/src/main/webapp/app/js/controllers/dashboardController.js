// EdneyRoldao - 27/06/2017
function DashboardController(profile, authenticationService, objectsFactory) {
    var ctrl = this;

    ctrl.mes = objectsFactory.getMes();

    ctrl.profile = profile.data;

    console.log(ctrl.profile);

    ctrl.logout = function () {
        authenticationService.logout();
    };

    ctrl.formatDate = "dd/MM/yyyy - EEEE";
    ctrl.formatTime = "HH:mm:ss";

    ctrl.showText = false;

    ctrl.picker2 = {
        date: new Date('2015-03-01T12:30:00Z'),
        timepickerOptions: {
            readonlyInput: false,
            showMeridian: false
        }
    };

    ctrl.changeText = function() {
        ctrl.showText = !ctrl.showText;
    };

    ctrl.openCalendar = function(e, picker) {
        ctrl[picker].open = true;
    };
}

DashboardController.$inject = ["userProfile", "AuthenticationService", "ObjectsFactory"];
angular.module("meuControleHorasApp").controller("DashboardController", DashboardController);