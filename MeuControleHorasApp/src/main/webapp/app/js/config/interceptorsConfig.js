// edneyRoldao - 25/05/17
angular.module("meuControleHorasApp").config(function ($httpProvider) {
	$httpProvider.interceptors.push("CacheControlInterceptor");
    $httpProvider.interceptors.push("HttpErrorInterceptor");
    $httpProvider.interceptors.push("CheckTokenInterceptor");    
    $httpProvider.interceptors.push("AccessControlInterceptor");
});