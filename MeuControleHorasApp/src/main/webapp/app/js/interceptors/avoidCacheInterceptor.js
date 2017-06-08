/* EdneyRoldao - 12/05/17 */
function AvoidCacheInterceptor() {
	var interceptor = {};

	interceptor.request = function(config) {
		if(config.url.indexOf("view") > -1) return config;

        var time = new Date().getTime();
        config.url = config.url + "?timestamp=" + time;

        return config;
	};

    return interceptor;
}

angular.module("meuControleHorasApp").factory("AvoidCacheInterceptor", AvoidCacheInterceptor);