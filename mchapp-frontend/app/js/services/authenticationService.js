// EdneyRoldao - 05/05/17
function AuthenticationService(state, tokenService) {
    var service = {};

    service.createAuthToken = function(user) {
        return tokenService.createToken(user);
    };

    service.login = function (token) {
        tokenService.saveToken(token);
        state.go("dashboard");
    };

    service.logout = function () {
        tokenService.deleteToken();
        state.go("home.login");
    };

    return service;
}

AuthenticationService.$inject = ["$state", "TokenService"];
angular.module("meuControleHorasApp").factory("AuthenticationService", AuthenticationService);