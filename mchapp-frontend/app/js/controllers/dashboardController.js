// EdneyRoldao - 27/06/2017
function DashboardController(profile, authenticationService, objectsFactory, registroService) {
    var ctrl = this;
    ctrl.profile = profile.data;

    ctrl.init = function() {
        registroService.listarRegistrosAtuais()
            .success(function(data) {
                console.log("Objeto:");
                console.log(data);
            }).error(function(error, status) {
                console.log("status code: " + status);
            });
    };

    ctrl.mes = objectsFactory.getMes();

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

    ctrl.init();
}

DashboardController.$inject = [];
DashboardController.$inject.push("userProfile");
DashboardController.$inject.push("AuthenticationService");
DashboardController.$inject.push("ObjectsFactory");
DashboardController.$inject.push("RegistroPontoService");
angular.module("meuControleHorasApp").controller("DashboardController", DashboardController);