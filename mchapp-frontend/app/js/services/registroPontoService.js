// Edney Roldão - 13/11/2017
function RegistroPontoService(http, constants) {
	var service = {};
	var URL = constants.appContextUrl;

	service.listarRegistrosAtuais = function() {
		return http.get(URL + "registros");
	};

	service.listarRegistrosPorPeriodo = function(params) {
		return http.get(URL + "registros/anteriores/" + params);
	};

	return service;
}

RegistroPontoService.$inject = ["$http", "ConstantsApp"];
angular.module("meuControleHorasApp").factory("RegistroPontoService", RegistroPontoService);