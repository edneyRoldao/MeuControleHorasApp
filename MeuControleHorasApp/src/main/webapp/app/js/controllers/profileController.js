function ProfileController() {
    var ctrl = this;
    ctrl.img = "";
    ctrl.types = ["image/png", "image/jpeg", "image/gif"];

    ctrl.test = function() {
    	console.log("test ng change");
    }

}

angular.module("meuControleHorasApp").controller("ProfileController", ProfileController);