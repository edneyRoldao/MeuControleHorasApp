/* EdneyRoldao - 16/06/17 */
function UserProfileService(http, constants) {
	var service = {};
    var URL = constants.appContextUrl;

    service.getProfile = function() {
        return http.get(URL + "profile");
    };

	return service;
}

UserProfileService.$inject = ["$http", "ConstantsApp"];
angular.module("meuControleHorasApp").factory("UserProfileService", UserProfileService);