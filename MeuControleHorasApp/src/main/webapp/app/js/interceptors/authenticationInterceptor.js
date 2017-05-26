/* EdneyRoldao - 12/05/17 */
function AuthInterceptor(ManageTokenService, $q, $location) {
    return {
		request: function(config) {
			config.headers = config.headers || {};

			if(ManageTokenService.getToken()) 
				config.headers["Authorization"] = "Bearer " + ManageTokenService.getToken();
			
			return config;
		},
		
		responseError: function(response) {
			if(response.status === 401 || response.status === 403)
				$location.path("/login"); 

			return $q.reject(response);
		}
    };
}

angular.module("meuControleHorasApp").factory("AuthInterceptor", AuthInterceptor);