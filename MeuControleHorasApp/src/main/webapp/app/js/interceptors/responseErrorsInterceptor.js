/* EdneyRoldao - 12/05/17 */
function ResponseErrorsInterceptor(promise, location) {
    var interceptor = {};

	var _deleteToken = function() {
		localStorage.removeItem(constants.tokenKey);
        console.log("userToken deleted");
	};

    interceptor.responseError = function(rejection) {
    	var status = rejection.status;

        if(status === 500) {
            location.path("/erroServidor");
        }

		if(rejection.status === 401 || rejection.status === 403) {
			_deleteToken();
			location.path("/login");
		}
        
        return promise.reject(rejection);
    };

    return interceptor;
}

ResponseErrorsInterceptor.$inject = ["$q", "$location"];
angular.module("meuControleHorasApp").factory("ResponseErrorsInterceptor", ResponseErrorsInterceptor);