function ProfileController() {
    var ctrl = this;

    ctrl.profile = {};

    ctrl.profile.address = "Rua Mere Marie Anais de Sion - Tucuruvi - São Paulo - SP - CEP:02343-030";

    ctrl.img = "";
    ctrl.types = ["image/png", "image/jpeg", "image/gif"];

    ctrl.btnFirstForm = {
        'btn btn-success': true,
        'btn btn-white': false
    };

    ctrl.btnSecondForm = {
        'btn btn-success': false,
        'btn btn-white': true
    };

    ctrl.btnThirdForm = {
        'btn btn-success': false,
        'btn btn-white': true
    };

    ctrl.showPersonalDataForm = true;
    ctrl.showAvatarForm = false;
    ctrl.showJobDataForm = false;

    ctrl.test = function() {
    	console.log("test ng change");
    };

    ctrl.changeForm = function(form) {
        changeCssFromButton(form);
    };

    ctrl.update = function() {
        console.log("calling update function from user profile screen");
    };

    function changeCssFromButton (form) {
        switch (form) {
            case 1:
                ctrl.showPersonalDataForm = true;
                ctrl.showAvatarForm = false;
                ctrl.showJobDataForm = false;
                ctrl.btnFirstForm['btn btn-success'] = true;
                ctrl.btnFirstForm['btn btn-white'] = false;
                ctrl.btnSecondForm['btn btn-success'] = false;
                ctrl.btnSecondForm['btn btn-white'] = true;
                ctrl.btnThirdForm['btn btn-success'] = false;
                ctrl.btnThirdForm['btn btn-white'] = true;
                break;
            case 2:
                ctrl.showPersonalDataForm = false;
                ctrl.showAvatarForm = true;
                ctrl.showJobDataForm = false;
                ctrl.btnSecondForm['btn btn-success'] = true;
                ctrl.btnSecondForm['btn btn-white'] = false;
                ctrl.btnFirstForm['btn btn-success'] = false;
                ctrl.btnFirstForm['btn btn-white'] = true;
                ctrl.btnThirdForm['btn btn-success'] = false;
                ctrl.btnThirdForm['btn btn-white'] = true;
                break;
            case 3:
                ctrl.showPersonalDataForm = false;
                ctrl.showAvatarForm = false;
                ctrl.showJobDataForm = true;
                ctrl.btnThirdForm['btn btn-success'] = true;
                ctrl.btnThirdForm['btn btn-white'] = false;
                ctrl.btnFirstForm['btn btn-success'] = false;
                ctrl.btnFirstForm['btn btn-white'] = true;
                ctrl.btnSecondForm['btn btn-success'] = false;
                ctrl.btnSecondForm['btn btn-white'] = true;
                break;
        }
    }

}

angular.module("meuControleHorasApp").controller("ProfileController", ProfileController);