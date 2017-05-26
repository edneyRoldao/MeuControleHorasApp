/* EdneyRoldao - 26/05/2017 */
function ManageTokenService($q, $localStorage) {
    var _getToken  = function() {
        return $localStorage.token;
    };

    var _setToken = function(token) {
        $localStorage.token = token;
    };,

    var _logout = function(data) {
        delete $localStorage.token;
        $q.when();
    };

    return {
		getToken: _getToken,
		setToken: _setToken,
		logout: _logout
    }
}

angular.module("meuControleHorasApp").factory("ManageTokenService", ManageTokenService);