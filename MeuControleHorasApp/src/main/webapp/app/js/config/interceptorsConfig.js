// edneyRoldao - 25/05/17
angular.module("meuControleHorasApp").config(function ($httpProvider) {
    $httpProvider.interceptors.push("AvoidCacheInterceptor");
    $httpProvider.interceptors.push("ServerErrorInterceptor");
    $httpProvider.interceptors.push("CheckTokenInterceptor");    
});