/* EdneyRoldao - 01/06/17 */
function TokenService(localStorage) {

    var _saveToken = function (username) {
        console.log(localStorage);
        console.log(username);
    };

    return {
        saveToken: _saveToken
    };
}

TokenService.$inject = ["$localStorage"];
angular.module("meuControleHorasApp").factory("TokenService", TokenService);