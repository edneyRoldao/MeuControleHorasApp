/* EdneyRoldao - 12/05/17 */
function ResponseErrorsInterceptor(promise, state, constants) {
    var interceptor = {};

	var _deleteToken = function() {
		localStorage.removeItem(constants.tokenKey);
        console.log("userToken deleted");
	};

    interceptor.responseError = function(rejection) {
    	var status = rejection.status;

        if(status === 500) {
            state.go("erroServidor");
        }

		if(rejection.status === 401 || rejection.status === 403) {
			_deleteToken();
			state.go("home.login");
		}
        
        return promise.reject(rejection);
    };

    return interceptor;
}

ResponseErrorsInterceptor.$inject = ["$q", "$state", "ConstantsApp"];
angular.module("meuControleHorasApp").factory("ResponseErrorsInterceptor", ResponseErrorsInterceptor);