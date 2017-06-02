// EdneyRoldao - 05/05/17
function AuthenticationService(http, constantsApp) {
    var service = {};
    var URL = constantsApp.appContextUrl;

    service.createAuthToken = function(user) {
        return http.post(URL + "auth", user);
    };

    return service;
}

AuthenticationService.$inject = ["$http", "ConstantsApp"];
angular.module("meuControleHorasApp").factory("AuthenticationService", AuthenticationService);