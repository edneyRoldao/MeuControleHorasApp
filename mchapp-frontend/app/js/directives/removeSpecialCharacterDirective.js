// EdneyRoldao - 21/05/17
function RemoveSpecialCharacter() {
    var directive = {};

    directive.require = "ngModel";

    directive.restrict = "A";

    directive.link = function(scope, element, attrs, ctrl) {
        var _removeSpecialCharacter = function (inputValue) {
            inputValue = inputValue.replace(/\W/, "");
            return inputValue;
        };

        element.bind('keyup', function() {
            ctrl.$setViewValue(_removeSpecialCharacter(ctrl.$viewValue));
            ctrl.$render();
        });
    };

    return directive;
}

angular.module("meuControleHorasApp").directive("removeSpecialCharacter", RemoveSpecialCharacter);
