/* EdneyRoldao - 12/05/17 */
function CacheControlInterceptor() {
	var interceptor = {};

	interceptor.request = function(config) {
		if(config.url.indexOf("views") > -1) return config;
		if(config.url.indexOf("time-picker.html") > -1) return config;
		if(config.url.indexOf("timepicker.html") > -1) return config;
		if(config.url.indexOf("date-picker.html") > -1) return config;
		if(config.url.indexOf("toast.html") > -1) return config;

        var time = new Date().getTime();
        config.url = config.url + "?timestamp=" + time;

        return config;
	};

    return interceptor;
}

angular.module("meuControleHorasApp").factory("CacheControlInterceptor", CacheControlInterceptor);