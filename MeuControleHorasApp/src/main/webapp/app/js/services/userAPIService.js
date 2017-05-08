function UserAPIService($http, constantsApp) {
    var URL = constantsApp.appContextUrl;

    var _getUser = function(username) {
        return $http.get("/usuario/" + username);
    };

    var _createUser = function(user) {
        return $http.post(URL + "/usuario", user);
    };

    return {
        getUser: _getUser,
        createUser: _createUser
    };
}

angular.module("meuControleHorasApp").factory("UserAPIService", UserAPIService);