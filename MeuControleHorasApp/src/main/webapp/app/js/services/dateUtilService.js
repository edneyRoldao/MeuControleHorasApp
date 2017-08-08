// EdneyRoldao - 05/08/17
function DateUtilService() {
    var service = {};

    service.getDaysOfMonth = function() {
        return [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17,
                18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31];
    };

    service.getMonths = function() {
        return [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12];
    };

    service.getRangeYearsValidToWork = function() {
        var years = [];
        var maxYear = moment().year() - 90;
        var minYear = moment().subtract(14, "years").year();

        for(var i = minYear; i > maxYear; i--)
            years.push(i);

        return years;
    };

    service.isDateValid = function (day, month, year) {
        return moment([year, month, day]).isValid();
    };

    return service;
}

angular.module("meuControleHorasApp").factory("DateUtilService", DateUtilService);