/* Edney Roldão - 14/08/2017 */
function HoursMask() {
	var directive = {};
    directive.require = "ngModel";
    directive.restrict = "A";

    directive.link = function(scope, element, attrs, ctrl) {
    	var _justNumbersFormatter = function(input) {
    		input = input.replace(/[^0-9]+/g, "");

			if(input.length > 3) {
				input = input.substring(0, 3);
			}

    		return input;
    	};

		element.bind('keyup', function() {
			ctrl.$setViewValue(_justNumbersFormatter(ctrl.$viewValue));
			ctrl.$render();
		});
    };

	return directive;
}

angular.module("meuControleHorasApp").directive("hoursMask", HoursMask);
