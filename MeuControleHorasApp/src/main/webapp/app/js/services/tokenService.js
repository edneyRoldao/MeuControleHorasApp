/* EdneyRoldao - 01/06/17 */
function TokenService(constants, jwt, http) {
	var service = {};
	var tokenKey = constants.tokenKey;
    var URL = constants.appContextUrl;

    service.saveToken = function (token) {
		localStorage.setItem(tokenKey, token);
		console.log("token added in local storage");
	};

	service.setToken = function(token) {
		service.saveToken(token);
    };

	service.getToken = function() {
		return localStorage.getItem(tokenKey);
	};

	service.deleteToken = function() {
		localStorage.removeItem(tokenKey);
        console.log("userToken deleted");
    };

    service.getPayload = function(token) {
    	return jwt.decodeToken(token);
    };

    service.isTokenExpired = function(token) {
		return jwt.isTokenExpired(token);
    };

    service.getExpirationDate = function(token) {
		return jwt.getTokenExpirationDate(token);
    };

    service.refreshToken = function() {
		return http.get(URL + "refresh");
    };

    service.createToken = function(user) {
        return http.post(URL + "auth", user);
    };

    return service;
}

TokenService.$inject = ["ConstantsApp", "jwtHelper", "$http"];
angular.module("meuControleHorasApp").factory("TokenService", TokenService);
