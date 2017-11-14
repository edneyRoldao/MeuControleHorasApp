// Edney Roldão - 13/11/2017
function RegistroPontoService(http, constants) {
	var service = {};
	var URL = constants.appContextUrl;

	service.listarRegistrosMesAtual = function() {
		var listaRegistros = [];

		http.get(URL + "registros")
			.success(function(data) {
				listaRegistros = data;
	        }).error(function(error, status) {
	            console.log("There was an error when trying to retrieve data");
	            console.log("status code: " + status);
	        }
        );

    	return _listaRegistrosFormatter(listaRegistros);
	};

	service.listarRegistrosPorPeriodo = function(params) {
		return http.get(URL + "registros/anteriores/" + params);
	};

	return service;
}

RegistroPontoService.$inject = ["$http", "ConstantsApp"];
angular.module("meuControleHorasApp").factory("RegistroPontoService", RegistroPontoService);

// Private functions
function _listaRegistrosFormatter(registros) {
	var listaFormatada =  registros.map(function(reg) {
		var regFormatado = {};

		var ano = reg.dataRegistro.year;
		var mes = reg.dataRegistro.monthValue;
		var dia = reg.dataRegistro.dayOfMonth;

		regFormatado.atividades = reg.atividades;
		regFormatado.data = dia + "/" + mes + "/" + ano;
		regFormatado.diaSemana = reg.dataRegistro.dayOfWeek;

		var horarios = _getRegistrosAsObject(reg.registros)
		regFormatado.entrada = horarios[0];
		regFormatado.intervalos = horarios[1];
		regFormatado.saida = horarios[2];

		regFormatado.total = _calculaTotalHoras(regFormatado);

		return regFormatado;
	});

	return listaFormatada;
}

function _calculaTotalHoras(registros) {
	return 0;
}

function _getRegistrosAsObject(registros) {
	var horarios = {};
	var size = registros.length;

	horarios.entrada = size > 0 ? registros[0] : "";
	horarios.saida = (size % 2 === 0 && size > 0) ? registros[size - 1] : "";

	// intervalos
	horarios.intervalos = [];

	if(size > 2) {
		horarios.intervalos = registros;
		horarios.intervalos.pop();
		horarios.intervalos.shift();
	}

	return horarios;
}


// quando 