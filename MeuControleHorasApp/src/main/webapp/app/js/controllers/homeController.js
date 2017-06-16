// EdneyRoldao - 04/04/2017
function HomeController(userProfile) {
    var ctrl = this;

    console.log("user profile retrieve");
    console.log(userProfile.data);

/*authenticationService*/

/*
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
*/
}

//HomeController.$inject = ["AuthenticationService"];
angular.module("meuControleHorasApp").controller("HomeController", HomeController);