angular.module("meuControleHorasApp").config(function($routeProvider) {

    $routeProvider.when("/home", {
        templateUrl: "app/view/home.html",
        controller: "homeController as ctrl"
    });

    $routeProvider.otherwise({ redirectTo: "/home" });
});