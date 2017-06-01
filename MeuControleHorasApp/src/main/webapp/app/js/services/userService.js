// EdneyRoldao
function UserService(http, constantsApp) {
    var URL = constantsApp.appContextUrl;

    var _createUser = function(user) {
        return http.post(URL + "usuario", user);
    };
    
    var _activateAccount = function(serialCode) {
        return http.get(URL + "usuario/" + serialCode);
    };

    var _retrievePassword = function(email) {
    	return http.post(URL + "usuario/redefinirSenha", email);
    };

    return {
        createUser: _createUser,
        activateAccount: _activateAccount,
        retrievePassword: _retrievePassword
    };
}

UserService.$inject = ["$http", "ConstantsApp"];
angular.module("meuControleHorasApp").factory("UserService", UserService);