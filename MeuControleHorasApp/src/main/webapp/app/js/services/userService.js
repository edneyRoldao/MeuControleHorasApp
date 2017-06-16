/* EdneyRoldao - 01/06/17 */
function UserService(http, constants) {
    var service = {};
    var URL = constants.appContextUrl;

    service.createUser = function(user) {
        return http.post(URL + "usuario", user);
    };
    
    service.activateAccount = function(serialCode) {
        return http.get(URL + "usuario/" + serialCode);
    };

    service.retrievePassword = function(email) {
    	return http.post(URL + "usuario/redefinirSenha", email);
    };

    service.buildUserObject = function (userFromForm) {
        var user = {};

        user.username = userFromForm.email;
        user.password = userFromForm.password;
        user.firstname = userFromForm.username;

        return user;
    };

    return service;
}

UserService.$inject = ["$http", "ConstantsApp"];
angular.module("meuControleHorasApp").factory("UserService", UserService);