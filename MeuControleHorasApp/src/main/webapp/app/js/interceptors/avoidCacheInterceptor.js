/* EdneyRoldao - 12/05/17 */
function AvoidCacheInterceptor() {
    return {
        request: function (config) {
            if(config.url.indexOf("view") > -1) return config; // html files can be cached.

            var time = new Date().getTime();
            config.url = config.url + "?timestamp=" + time;

            return config;
        }
    };
}

angular.module("meuControleHorasApp").factory("AvoidCacheInterceptor", AvoidCacheInterceptor);