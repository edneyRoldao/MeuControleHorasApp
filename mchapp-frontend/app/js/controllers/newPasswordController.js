/* Edney Roldao - 16/08/2017 */
function NewPasswordController(profile, userService, state) {
    var ctrl = this;

    ctrl.changePassword = function() {
    	ctrl.user = {};
    	ctrl.user.username = profile.data.email;
    	ctrl.user.password = ctrl.pass.old;
    	ctrl.user.newPassword = ctrl.pass.new;

    	userService.changePassword(ctrl.user)
            .success(function(data) {                
                state.go("dashboard");

                toastr.success("Senha alterada com sucesso",'Sucesso !', {
                    closeButton: true,
                    progressBar: true
                });

            }).error(function(err, status) {
            	var msg = "";
            	if(status === 400) {
            		msg = 'A senha atual que foi informada não confere !';
            	}else {
                	msg = 'Aconteceu um erro no servidor, tente novamente em alguns minutos.';
            	}

                toastr.error(msg,'Erro !', {
                        closeButton: true,
                        progressBar: true
                    });

                console.log(err);
                console.log(status);
        });
    };

}

NewPasswordController.$inject = [];
NewPasswordController.$inject.push("userProfile");
NewPasswordController.$inject.push("UserService");
NewPasswordController.$inject.push("$state");
angular.module("meuControleHorasApp").controller("NewPasswordController", NewPasswordController);