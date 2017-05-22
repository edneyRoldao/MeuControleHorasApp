// EdneyRoldao - 21/05/17
function RemoveSpecialCharacter() {
    return {
        require: "ngModel",
        link: function(scope, element, attrs, ctrl) {

            var _removeSpecialCharacter = function (inputValue) {
                inputValue = inputValue.replace(/\W/, "");
                return inputValue;
            };

            element.bind('keyup', function() {
                ctrl.$setViewValue(_removeSpecialCharacter(ctrl.$viewValue));
                ctrl.$render();
            });
        }
    };
}

angular.module("meuControleHorasApp").directive("removeSpecialCharacter", RemoveSpecialCharacter);
