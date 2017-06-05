// EdneyRoldao - 05/05/17
function AuthenticationService(http, constantsApp, location, tokenService) {
    var service = {};
    var URL = constantsApp.appContextUrl;

    service.createAuthToken = function(user) {
        return http.post(URL + "auth", user);
    };

    service.testRoles = function () {
        return http.get(URL + "protected");
    };

    service.login = function (token) {
        tokenService.saveToken(token);
        location.path("/principal");
    };

    service.logout = function () {
        tokenService.deleteToken();
        location.path("/login");
    };

    return service;
}

AuthenticationService.$inject = ["$http", "ConstantsApp", "$location", "TokenService"];
angular.module("meuControleHorasApp").factory("AuthenticationService", AuthenticationService);