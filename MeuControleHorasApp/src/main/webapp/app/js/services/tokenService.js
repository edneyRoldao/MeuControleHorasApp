/* EdneyRoldao - 01/06/17 */
function TokenService() {
	var service = {};

    service.saveToken = function (token) {
		localStorage.setItem("userToken", token);    
	};

	service.getToken = function() {
		return localStorage,getItem("userToken");  
	};

	service.setToken = function(token) {
		localStorage.setItem("userToken", token);
	};

	service.deleteToken = function() {
		localStorage.removeItem("userToken");
	};

    return service;
}

angular.module("meuControleHorasApp").factory("TokenService", TokenService);