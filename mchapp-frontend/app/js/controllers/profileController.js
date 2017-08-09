function ProfileController(dateUtil, searchAddress, toastAlert, profile) {
    var ctrl = this;

    ctrl.profile = profile.data;

    ctrl.days = dateUtil.getDaysOfMonth();
    ctrl.months = dateUtil.getMonths();
    ctrl.years = dateUtil.getRangeYearsValidToWork();

    ctrl.cep = "";
    ctrl.profile = {};
    ctrl.profile.address = {};

    ctrl.types = ["image/png", "image/jpeg", "image/gif"];
    ctrl.image = "";
    ctrl.profile.avatar = "";

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

    ctrl.changeForm = function(form) {
        changeCssFromButton(form);
    };

    ctrl.update = function() {
        toastAlert.success("test", "test");
    };

    ctrl.searchAddress = function() {
        if(ctrl.cep) {
            searchAddress.searchAddressFromCEP(ctrl.cep)
                .success(function(data) {

                    if(data.erro) {
                        ctrl.profile.address = "";
                        toastAlert.warning("este cep n\u00e3o existe !", "Erro", {
                            closeButton: true
                        });
                    }else {
                        ctrl.profile.address = data;
                    }

                }).error(function(err, status) {
                    console.log("There was an error: " + err);
                    console.log("HTTP STATUS CODE: " + status);
            });            
        }
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

ProfileController.$inject = ["DateUtilService", "SearchAddressService", "toastr", "userProfile"];
angular.module("meuControleHorasApp").controller("ProfileController", ProfileController);
