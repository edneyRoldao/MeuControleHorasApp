// EdneyRoldao - 05/05/17
function AuthenticationService(http, constantsApp) {
    var URL = constantsApp.appContextUrl;

    var _createAuthToken = function(user) {
        return http.post(URL + "auth", user);
    };

    var _refreshAuthToken = function () {

    };

    return {
        createAuthToken: _createAuthToken,
        refreshAuthToken: _refreshAuthToken
    };
}

AuthenticationService.$inject = ["$http", "ConstantsApp"];
angular.module("meuControleHorasApp").factory("AuthenticationService", AuthenticationService);