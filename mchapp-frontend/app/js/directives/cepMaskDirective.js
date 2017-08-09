/* Edney Roldao - 09/08/17 */
function CepMask() {
	var directive = {};

	directive.restrict = "A";
	directive.require = "ngModel";

	directive.link = function(scope, element, attrs, ctrl) {

		var _formatCepNumber = function(cep) {
			cep = cep.replace(/[^0-9]+/g, "");

			if(cep.length > 5) {
				cep = cep.substring(0, 5) + "-" + cep.substring(5);
			}

			if(cep.length > 8) {
				cep = cep.substring(0, 9);
			}

			return cep;
		};

		element.bind("keyup", function() {
			ctrl.$setViewValue(_formatCepNumber(ctrl.$viewValue));
			ctrl.$render();
		});

		ctrl.$parsers.push(function(cep) {
			if(cep.length === 9) return cep.replace("-", "");
		});

		ctrl.$formatters.push(function(cep) {
			return _formatCepNumber(cep);
		});

	};

	return directive;
}

angular.module("meuControleHorasApp").directive("cepMask", CepMask);
	