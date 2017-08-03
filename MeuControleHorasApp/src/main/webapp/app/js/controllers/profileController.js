function ProfileController() {
    var ctrl = this;

    ctrl.img = "";
    ctrl.types = ["image/png", "image/jpeg", "image/gif"];

    ctrl.btnFirstForm = {
        'btn btn-success btn-sm': true,
        'btn btn-white btn-sm': false
    };

    ctrl.btnSecondForm = {
        'btn btn-success btn-sm': false,
        'btn btn-white btn-sm': true
    };

    ctrl.btnThirdForm = {
        'btn btn-success btn-sm': false,
        'btn btn-white btn-sm': true
    };

    ctrl.test = function() {
    	console.log("test ng change");
    };

    ctrl.changeForm = function(form) {
        changeCssFromButton(form);
    };

    function changeCssFromButton (form) {
        switch (form) {
            case 1:
                ctrl.btnFirstForm['btn btn-success btn-sm'] = true;
                ctrl.btnFirstForm['btn btn-white btn-sm'] = false;
                ctrl.btnSecondForm['btn btn-success btn-sm'] = false;
                ctrl.btnSecondForm['btn btn-white btn-sm'] = true;
                ctrl.btnThirdForm['btn btn-success btn-sm'] = false;
                ctrl.btnThirdForm['btn btn-white btn-sm'] = true;
                break;
            case 2:
                ctrl.btnSecondForm['btn btn-success btn-sm'] = true;
                ctrl.btnSecondForm['btn btn-white btn-sm'] = false;
                ctrl.btnFirstForm['btn btn-success btn-sm'] = false;
                ctrl.btnFirstForm['btn btn-white btn-sm'] = true;
                ctrl.btnThirdForm['btn btn-success btn-sm'] = false;
                ctrl.btnThirdForm['btn btn-white btn-sm'] = true;
                break;
            case 3:
                ctrl.btnThirdForm['btn btn-success btn-sm'] = true;
                ctrl.btnThirdForm['btn btn-white btn-sm'] = false;
                ctrl.btnFirstForm['btn btn-success btn-sm'] = false;
                ctrl.btnFirstForm['btn btn-white btn-sm'] = true;
                ctrl.btnSecondForm['btn btn-success btn-sm'] = false;
                ctrl.btnSecondForm['btn btn-white btn-sm'] = true;
                break;
        }
    }

}

angular.module("meuControleHorasApp").controller("ProfileController", ProfileController);