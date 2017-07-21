function ProfileController() {
    var ctrl = this;
    ctrl.image = null;
    ctrl.imageFileName = "";
    ctrl.uploadme = {};
    ctrl.uploadme.src = "";
}

angular.module("meuControleHorasApp").controller("ProfileController", ProfileController);