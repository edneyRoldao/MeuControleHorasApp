/*
    EdneyRoldao - 12/05/17
    This interceptor will lead with unexpected error from the server.
 */
function ServerErrorInterceptor($q, $location) {
    return {
        responseError: function (rejection) {
            if(rejection.status === 500) {
                console.log("passei aqui");
                $location.path("/erroServidor");
            }

            return $q.reject(rejection);
        }  
    };
}

angular.module("meuControleHorasApp").factory("ServerErrorInterceptor", ServerErrorInterceptor);