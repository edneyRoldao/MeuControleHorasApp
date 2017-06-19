/* EdneyRoldao - 13/06/2017 */
function AccessControlInterceptor(constants, location, jwt) {
	var interceptor = {};
	
	var _getToken = function() {
		return localStorage.getItem(constants.tokenKey);
	};

	var _deleteToken = function() {
		localStorage.removeItem(constants.tokenKey);
        console.log("userToken deleted");
	};

	interceptor.request = function(config) {
		config.headers = config.headers || {};
		
		if(_getToken()) {
			config.headers["X-Auth-Token"] = _getToken();
		}	

		var urlList = constants.urlListAccessControlled;

		for(var i = 0; i < urlList.length; i++) {
			if(config.url == urlList[i] && (!_getToken() || jwt.isTokenExpired(_getToken()))) {
				location.path("/login");
			}
		}
		
		return config;
	};
	
	return interceptor;
}

AccessControlInterceptor.$inject = ["ConstantsApp", "$location", "jwtHelper"];
angular.module("meuControleHorasApp").factory("AccessControlInterceptor", AccessControlInterceptor);