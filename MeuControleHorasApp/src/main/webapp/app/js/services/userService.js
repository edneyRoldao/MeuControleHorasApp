// EdneyRoldao
function UserService(http, constantsApp) {
    var service = {};
    var URL = constantsApp.appContextUrl;

    service.createUser = function(user) {
        return http.post(URL + "usuario", user);
    };
    
    service.activateAccount = function(serialCode) {
        return http.get(URL + "usuario/" + serialCode);
    };

    service.retrievePassword = function(email) {
    	return http.post(URL + "usuario/redefinirSenha", email);
    };

    return service;
}

UserService.$inject = ["$http", "ConstantsApp"];
angular.module("meuControleHorasApp").factory("UserService", UserService);