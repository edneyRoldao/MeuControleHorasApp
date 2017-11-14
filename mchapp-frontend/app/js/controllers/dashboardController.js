// EdneyRoldao - 27/06/2017
function DashboardController(profile, authenticationService, registroService) {
    var ctrl = this;

    // Variables
    ctrl.registros = [];
    ctrl.showText = false;
    ctrl.profile = profile.data;
    ctrl.formatTime = "HH:mm:ss";
    ctrl.formatDate = "dd/MM/yyyy - EEEE";

    // Objects
    ctrl.picker2 = {
        date: new Date('2015-03-01T12:30:00Z'),
        timepickerOptions: {
            readonlyInput: false,
            showMeridian: false
        }
    };

    // Functions
    ctrl.logout = function () {
        authenticationService.logout();
    };

    ctrl.changeText = function() {
        ctrl.showText = !ctrl.showText;
    };

    ctrl.openCalendar = function(e, picker) {
        ctrl[picker].open = true;
    };

    // Call functions
    ctrl.registros = registroService.listarRegistrosMesAtual();
}

// imports
DashboardController.$inject = [];
DashboardController.$inject.push("userProfile");
DashboardController.$inject.push("AuthenticationService");
DashboardController.$inject.push("RegistroPontoService");

// Controller register
angular.module("meuControleHorasApp").controller("DashboardController", DashboardController);