// EdneyRoldao - 04/04/2017
function HomeController(authenticationService) {
    var ctrl = this;

    ctrl.logout = function () {
        authenticationService.logout();
    };

}

HomeController.$inject = ["AuthenticationService"];
angular.module("meuControleHorasApp").controller("HomeController", HomeController);