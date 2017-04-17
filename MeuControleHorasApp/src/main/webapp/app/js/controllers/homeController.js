// EdneyRoldao - 04/04/2017
function indexController() {
    lowScope = this;
    lowScope.name = "edney";
    console.log(lowScope);
}

angular.module("meuControleHorasApp").controller("homeController", indexController);