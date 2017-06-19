/* EdneyRoldao - 13/06/2017 */
function AccessControlInterceptor(constants) {
	var interceptor = {};
	
	interceptor.request = function(config) {

		console.log("current url: " + config.url);

		constants.urlListAccessControlled.forEach(function(url) {
			console.log(url);
		});
		
		return config;
	};
	
	return interceptor;
}

AccessControlInterceptor.$inject = ["ConstantsApp"];
angular.module("meuControleHorasApp").factory("AccessControlInterceptor", AccessControlInterceptor);