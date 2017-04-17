angular.module("meuControleHorasApp").controller("loginController", function($scope) {

    $scope.user = {};

    $scope.userLogin = function() {
        console.log($scope.user);
    };


});