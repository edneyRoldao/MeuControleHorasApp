function ProfileController(dateUtil, searchAddress, profile, profileService, state) {
    var ctrl = this;

    ctrl.avatar = "";
    ctrl.profile = profile.data;
    ctrl.percentage = _howMuchFieldsAreFilled(ctrl.profile);

    ctrl.types = ["image/png", "image/jpeg", "image/gif", "image/jpg"];

    ctrl.days = dateUtil.getDaysOfMonth();
    ctrl.months = dateUtil.getMonths();
    ctrl.years = dateUtil.getRangeYearsValidToWork();

    ctrl.showPersonalDataForm = true;
    ctrl.showAvatarForm = false;
    ctrl.showJobDataForm = false;

    if(ctrl.profile.birthDate) {
        _convertDateToNumber(ctrl.profile.birthDate);
    }

    ctrl.update = function() {
        if(ctrl.avatar !== profileService.getDefaultImage()) {
            ctrl.profile.avatar = ctrl.avatar;
        }

        if(!ctrl.profile.name || ctrl.profile.name.length < 3) {
            var msg = 'O campo nome não foi preenchido corretamente';

            toastr.error(msg,'Erro!', {
                closeButton: true,
                progressBar: true
            });

            return;
        }

        if(ctrl.profile.valorHora && ctrl.profile.valorHora > 1000) {
            var msg = 'O valor por hora excede o limite permitido';

            toastr.error(msg,'Erro!', {
                closeButton: true,
                progressBar: true
            });

            return;
        }

        if(ctrl.day || ctrl.month || ctrl.year) {
            if(dateUtil.isDateValid(ctrl.year, ctrl.month - 1, ctrl.day)) {
                ctrl.profile.birthDate = moment([ctrl.year, ctrl.month - 1, ctrl.day]);

            }else {
                var msg = 'A data é inválida ou algum campo não foi selecionado';
                toastr.error(msg,'Erro no campo data de Nascimento !', {
                    closeButton: true,
                    progressBar: true
                });

                return;
            }
        }

        profileService.updateProfile(ctrl.profile)
            .success(function(data) {                
                state.go("dashboard");
                toastr.success("Perfil atualizado com sucesso",'Sucesso !', {
                    closeButton: true,
                    progressBar: true
                });

            }).error(function(err, status) {
                var msg = 'Aconteceu um erro no servidor, tente novamente em alguns minutos.';
                toastr.error(msg,'Erro !', {
                        closeButton: true,
                        progressBar: true
                    });
                console.log(err);
                console.log(status);
        });
    };

    ctrl.searchAddress = function() {
        if(ctrl.profile.address.cep) {
            searchAddress.searchAddressFromCEP(ctrl.profile.address.cep)
                .success(function(data) {
                    if(data.erro) {
                        ctrl.profile.address = {};

                        toastr.warning('O CEP digitado não existe.','Atenção !', {
                            closeButton: true,
                            progressBar: true
                        });

                    }else {
                        ctrl.profile.address.logradouro = data.logradouro;
                        ctrl.profile.address.bairro = data.bairro;
                        ctrl.profile.address.cidade = data.localidade;
                        ctrl.profile.address.uf = data.uf;
                    }

                }).error(function(err, status) {
                    toastr.error('Houve uma falha no servidor de pesquisa de CEP','Erro !', {
                        closeButton: true,
                        progressBar: true
                    });
                    console.log("There was an error: " + err);
                    console.log("HTTP STATUS CODE: " + status);
            });            
        }
    };

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

    ctrl.changeForm = function(form) {
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
    };

    function _convertDateToNumber(date) {
        var newDate = moment(date);
        ctrl.day = newDate.date();
        var month = newDate.month();
        ctrl.month = month + 1;
        ctrl.year = newDate.year();
    }

    function _howMuchFieldsAreFilled(profile) {
        var fieldsNumber = 11;
        var total = 3;

        if(profile.birthDate) total++;
        if(profile.gender) total++;
        if(profile.company) total++;    
        if(profile.profession) total++;    
        if(profile.valorHora) total++;    
        if(profile.horasPorMes) total++;    
        if(profile.maxHorasPorMes) total++;    
        if(profile.address && profile.address.cep) total++;

        var perc = (total * 100) / fieldsNumber;

        if(perc === 100) {
            ctrl.fillFormMsg = "Informações completas !"
        }else {
            ctrl.fillFormMsg = 
                "Para obter melhores experiências com o sistema, complete o formulário com seus dados";
        }

        return perc.toFixed();
    }

}

ProfileController.$inject = [];
ProfileController.$inject.push("DateUtilService");
ProfileController.$inject.push("SearchAddressService");
ProfileController.$inject.push("userProfile");
ProfileController.$inject.push("UserProfileService");
ProfileController.$inject.push("$state");
angular.module("meuControleHorasApp").controller("ProfileController", ProfileController);
