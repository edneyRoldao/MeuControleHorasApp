// EdneyRoldao - 04/04/2017
function HomeController(authenticationService) {
    var ctrl = this;

    ctrl.testRoles = function () {
        authenticationService.testRoles().success(function (data) {
            console.log("SUCCESS");

        }).error(function (data, status) {
            console.log(status);
        });
    };

    ctrl.logout = function () {
        authenticationService.logout();
    };

}

HomeController.$inject = ["AuthenticationService"];
angular.module("meuControleHorasApp").controller("HomeController", HomeController);