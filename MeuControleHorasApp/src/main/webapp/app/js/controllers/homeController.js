// EdneyRoldao - 04/04/2017
function HomeController(authenticationService, profile) {
    var ctrl = this;

    console.log(profile.data);

    ctrl.logout = function () {
        authenticationService.logout();
    };

}

HomeController.$inject = ["AuthenticationService", "userProfile"];
angular.module("meuControleHorasApp").controller("HomeController", HomeController);