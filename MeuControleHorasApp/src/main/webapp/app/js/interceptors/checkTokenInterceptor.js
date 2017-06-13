/* EdneyRoldao - 12/05/17 */
function CheckTokenInterceptor(promise, location) {
	var interceptor = {};

	var _getToken = function() {
		return localStorage.getItem("JWT_TOKEN");
	};

	var _deleteToken = function() {
		localStorage.removeItem("JWT_TOKEN");
        console.log("userToken deleted");
	}

	interceptor.request = function(config) {
		config.headers = config.headers || {};
		
		if(_getToken()) {
			config.headers["X-Auth-Token"] = _getToken();
			console.log("security token added on header");
		}else {
			console.log("There is no token in local storage.");
		}
	
		return config;
	};

	interceptor.responseError = function(rejection) {
		if(rejection && (rejection.status === 401 || rejection.status === 403)) {
			_deleteToken();
			location.path("/login");
		}

		return promise.reject(rejection);
	};

	return interceptor;
}

CheckTokenInterceptor.$inject = ["$q", "$location"];
angular.module("meuControleHorasApp").factory("CheckTokenInterceptor", CheckTokenInterceptor);