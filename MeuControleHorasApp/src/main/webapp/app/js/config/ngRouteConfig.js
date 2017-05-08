angular.module("meuControleHorasApp").config(function($routeProvider) {

    $routeProvider.when("/home", {
        templateUrl: "app/view/home.html",
        controller: "HomeController as homeCtrl"
    });

    $routeProvider.when("/login", {
        templateUrl: "app/view/login.html",
        controller: "AuthController as loginCtrl"
    });

    $routeProvider.when("/cadastro", {
        templateUrl: "app/view/new-user.html",
        controller: "UserController as userCtrl"
    });

    $routeProvider.otherwise({ redirectTo: "/home" });
});