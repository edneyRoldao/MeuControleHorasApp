/* EdneyRoldao - 13/06/2017 */
function AccessControlInterceptor(constants, state, jwt) {
	var interceptor = {};
	
	var _getToken = function() {
		return localStorage.getItem(constants.tokenKey);
	};

	interceptor.request = function(config) {

	    test();


	    if(config.url.indexOf("viacep") !== -1) return config;

		config.headers = config.headers || {};
		
		if(_getToken()) {
			config.headers["X-Auth-Token"] = _getToken();
		}	

		var urlList = constants.urlListAccessControlled;

		for(var i = 0; i < urlList.length; i++) {
			if(config.url == urlList[i] && (!_getToken() || jwt.isTokenExpired(_getToken()))) {
				state.go("home.login");
			}
		}
		
		return config;
	};
	
	return interceptor;
}

AccessControlInterceptor.$inject = ["ConstantsApp", "$state", "jwtHelper"];
angular.module("meuControleHorasApp").factory("AccessControlInterceptor", AccessControlInterceptor);

function test() {
    console.log("TEST TEST TEST");
}