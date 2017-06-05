/* EdneyRoldao - 01/06/17 */
function TokenService() {
	var service = {};

    service.saveToken = function (token) {
		localStorage.setItem("userToken", token);
		console.log("token added in local storage");
	};

	service.getToken = function() {
		return localStorage.getItem("userToken");
	};

	service.setToken = function(token) {
		localStorage.setItem("userToken", token);
        console.log("token added in local storage");
    };

	service.deleteToken = function() {
		localStorage.removeItem("userToken");
        console.log("userToken deleted");
    };

    return service;
}

angular.module("meuControleHorasApp").factory("TokenService", TokenService);