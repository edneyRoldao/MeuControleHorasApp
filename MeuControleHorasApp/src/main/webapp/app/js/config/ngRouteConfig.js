angular.module("meuControleHorasApp").config(function($routeProvider) {

    $routeProvider.when("/home", {
        templateUrl: "app/view/home.html",
        controller: "HomeController as ctrl"
    });

    $routeProvider.when("/login", {
        templateUrl: "app/view/login.html",
        controller: "LoginController as ctrl"
    });

    $routeProvider.when("/usuario", {
        templateUrl: "app/view/login.html",
        controller: "LoginController as ctrl"
    });

    $routeProvider.when("/ativarConta", {
        templateUrl: "app/view/activate-account.html",
        controller: "ActivateAccountController as ctrl"
    });

    $routeProvider.when("/redefinirSenha", {
        templateUrl: "app/view/password-retrieve.html",
        controller: "PasswordRetrieveController as ctrl"
    });

    $routeProvider.when("/cadastro", {
        templateUrl: "app/view/create-user.html",
        controller: "CreateUserController as ctrl"
    });

    $routeProvider.when("/erroServidor", {
        templateUrl: "app/view/error-page.html"
    });

    $routeProvider.when("/principal", {
        templateUrl: "app/view/dashboard.html",
        controller: "HomeController as ctrl",
        resolver: {
            userProfile: function() {
                return ;
            }
        }
    });

    $routeProvider.otherwise({ redirectTo: "/home" });
});