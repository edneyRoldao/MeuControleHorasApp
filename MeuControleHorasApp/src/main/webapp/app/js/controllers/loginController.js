// EdneyRoldao - 18/04/17
function LoginController() {
    var loginCrtl = this;

    loginCrtl.userAuth = function () {
        console.log(loginCrtl.user);
        console.log(loginCrtl.formLogin);
    };

}

angular.module("meuControleHorasApp").controller("LoginController", LoginController);