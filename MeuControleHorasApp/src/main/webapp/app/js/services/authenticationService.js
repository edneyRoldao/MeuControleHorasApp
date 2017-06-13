// EdneyRoldao - 05/05/17
function AuthenticationService(http, constants, location, tokenService) {
    var service = {};
    var URL = constants.appContextUrl;

    service.createAuthToken = function(user) {
        return tokenService.createToken(user);
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