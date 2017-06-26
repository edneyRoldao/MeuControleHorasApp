function uiRouterConfig(stateProvider, urlRouterProvider) {
    stateProvider.state("home", {
        url: "/home",
        views: {
            "": {templateUrl: "app/views/headers/home-header.html"},
            "homeBody@home": {
                templateUrl: "app/views/home.html",
                controller: "HomeController as ctrl"
            }
        }
    });

    stateProvider.state("home.login", {
        url: "/login",
        views: {
            "homeBody@home": {
                templateUrl: "app/views/login.html",
                controller: "LoginController as ctrl"
            }
        }
    });

    stateProvider.state("home.usuario", {
        url: "/usuario",
        views: {
            "homeBody@home": {
                templateUrl: "app/views/login.html",
                controller: "LoginController as ctrl"
            }
        }
    });

    stateProvider.state("home.ativarConta", {
        url: "/ativarConta",
        views: {
            "homeBody@home": {
                templateUrl: "app/views/activate-account.html",
                controller: "ActivateAccountController as ctrl"
            }
        }
    });

    stateProvider.state("home.redefinirSenha", {
        url: "/redefinirSenha",
        views: {
            "homeBody@home": {
                templateUrl: "app/views/password-retrieve.html",
                controller: "PasswordRetrieveController as ctrl"
            }
        }
    });

    stateProvider.state("home.cadastro", {
        url: "/cadastro",
        views: {
            "homeBody@home": {
                templateUrl: "app/views/create-user.html",
                controller: "CreateUserController as ctrl"
            }
        }
    });

    stateProvider.state("home.erroServidor", {
        url: "/erroServidor",
        views: {
            "homeBody@home": {
                templateUrl: "app/views/error-page.html"
            }
        }
    });

    

    urlRouterProvider.otherwise('/home');
}

uiRouterConfig.$inject = ["$stateProvider", "$urlRouterProvider"];
angular.module("meuControleHorasApp").config(uiRouterConfig);