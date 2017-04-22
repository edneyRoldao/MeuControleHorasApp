function ValidateNameField() {
    return {
        require: "ngModel",
        link: function(scope, element, attrs, ctrl) {
            element.bind('keyup', function() {
                if(!/^[a-zA-Z]+( [a-zA-Z]+)*$/.test(ctrl.$viewValue)) {
                    var value = ctrl.$viewValue;
                    value = value.replace(/\s{2,}/g, " ");
                    value = value.replace(/^\s|\s$|/g, "");
                    value = value.replace(/[^a-zA-Z ]+/g, "");

                    ctrl.$setViewValue(value);
                    ctrl.$render();
                }
            });
        }
    };
}

angular.module("meuControleHorasApp").directive("validateNameField", ValidateNameField);
