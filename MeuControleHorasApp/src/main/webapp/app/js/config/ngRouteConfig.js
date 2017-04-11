angular.module("meuControleHorasApp").config(function($routeProvider) {

    $routeProvider.when("/home", {
        templateUrl: "app/view/home.html",
        controller: "homeController"
    });

    $routeProvider.otherwise({ redirectTo: "/home" });

});