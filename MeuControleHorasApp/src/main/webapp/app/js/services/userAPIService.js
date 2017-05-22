// EdneyRoldao
function UserAPIService($http, constantsApp) {
    var URL = constantsApp.appContextUrl;

    var _createUser = function(user) {
        return $http.post(URL + "usuario", user);
    };

    var _activateAccount = function(serialCode) {
        return $http.get(URL + "usuario/" + serialCode);
    };

    return {
        createUser: _createUser,
        activateAccount: _activateAccount
    };
}

angular.module("meuControleHorasApp").factory("UserAPIService", UserAPIService);