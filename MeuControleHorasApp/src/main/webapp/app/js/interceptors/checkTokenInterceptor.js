/* EdneyRoldao - 12/05/17 */
function CheckTokenInterceptor(promise, location, tokenService) {
	var interceptor = {};

	interceptor.request = function(config) {
		config.headers = config.headers || {};
		
		if(tokenService.getToken()) {
			config.headers["X-Auth-Token"] = tokenService.getToken();
			console.log("security token added on header");
		}else {
			console.log("There is no token in local storage.");
		}
	
		return config;
	};

	interceptor.responseError = function(rejection) {
		if(rejection && (rejection.status === 401 || rejection.status === 403)) {
			tokenService.deleteToken();
			location.path("/login");
		}

		return promise.reject(rejection);
	};

	return interceptor;
}

CheckTokenInterceptor.$inject = ["$q", "$location", "TokenService"];
angular.module("meuControleHorasApp").factory("CheckTokenInterceptor", CheckTokenInterceptor);