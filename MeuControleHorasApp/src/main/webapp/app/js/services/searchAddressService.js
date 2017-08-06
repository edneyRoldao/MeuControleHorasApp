// Edney Roldao - 06/08/17
function SearchAddressService(http, constants) {
    var service = {};
    var URL = constants.addressWS;

    service.searchAddressFromCEP = function(cep) {
        return http.get(URL + cep + "/json/");
    };

    return service;
}

SearchAddressService.$inject = ["$http", "ConstantsApp"];
angular.module("meuControleHorasApp").factory("SearchAddressService", SearchAddressService);