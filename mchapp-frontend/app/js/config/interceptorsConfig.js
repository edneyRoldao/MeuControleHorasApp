// edneyRoldao - 25/05/17
angular.module("meuControleHorasApp").config(function ($httpProvider) {
	$httpProvider.interceptors.push("CacheControlInterceptor");
    $httpProvider.interceptors.push("ResponseErrorsInterceptor");
    $httpProvider.interceptors.push("AccessControlInterceptor");
});