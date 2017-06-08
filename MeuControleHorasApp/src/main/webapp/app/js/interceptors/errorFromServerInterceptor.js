/* EdneyRoldao - 12/05/17 */
function ServerErrorInterceptor(q, location) {
    var interceptor = {};

    interceptor.responseError = function(rejection) {
        if(rejection.status === 500) {
            console.log("server error interceptor is work");
            location.path("/erroServidor");
        }

        return q.reject(rejection);
    };

    return interceptor;
}

ServerErrorInterceptor.$inject = ["$q", "$location"];
angular.module("meuControleHorasApp").factory("ServerErrorInterceptor", ServerErrorInterceptor);