angular.module("meuControleHorasApp").config(function($routeProvider) {

    $routeProvider.when("/home", {
        templateUrl: "app/view/home.html",
        controller: "HomeController as homeCtrl"
    });

    $routeProvider.when("/login", {
        templateUrl: "app/view/login.html",
        controller: "LoginController as loginCtrl"
    });

    $routeProvider.when("/cadastro", {
        templateUrl: "app/view/new_user.html",
        controller: "NewUserController as newUserCtrl"
    });

    $routeProvider.otherwise({ redirectTo: "/home" });
});