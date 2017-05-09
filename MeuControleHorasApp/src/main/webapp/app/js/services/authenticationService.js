// EdneyRoldao - 05/05/17
function AuthService($http, constantsApp) {
    var URL = constantsApp.appContextUrl;

    var _createAuthToken = function(user) {
        return $http.post(URL + "auth", user);
    };

    var _refreshAuthToken = function () {

    };

    return {
        createAuthToken: _createAuthToken,
        refreshAuthToken: _refreshAuthToken
    };
}

angular.module("meuControleHorasApp").factory("AuthAPIService", AuthService);