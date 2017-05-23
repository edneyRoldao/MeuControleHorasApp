angular.module("meuControleHorasApp").config(function($routeProvider) {

    $routeProvider.when("/home", {
        templateUrl: "app/view/home.html",
        controller: "HomeController as homeCtrl"
    });

    $routeProvider.when("/login", {
        templateUrl: "app/view/login.html",
        controller: "AuthController as loginCtrl"
    });

    $routeProvider.when("/usuario", {
        templateUrl: "app/view/login.html",
        controller: "AuthController as loginCtrl"
    });

    $routeProvider.when("/activate", {
        templateUrl: "app/view/account-confirmation.html",
        controller: "AccountActivationController as ctrl"
    });

    $routeProvider.when("/redefinirSenha", {
        templateUrl: "app/view/password-forgotten.html",
        controller: "RetrieveEmailController as ctrl"
    });

    $routeProvider.when("/cadastro", {
        templateUrl: "app/view/new-user.html",
        controller: "UserController as userCtrl"
    });

    $routeProvider.otherwise({ redirectTo: "/home" });
});