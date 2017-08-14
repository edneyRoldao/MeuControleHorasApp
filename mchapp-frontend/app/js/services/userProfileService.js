/* EdneyRoldao - 16/06/17 */
function UserProfileService(http, constants) {
	var service = {};
    var URL = constants.appContextUrl;

    service.getProfile = function() {
        return http.get(URL + "profile");
    };

    service.updateProfile = function(profile) {
        return http.put(URL + "profile", profile);
    };

    service.getDefaultImage = function () {
        return constants.getDefaultImage;
    };

    service.getInstance = getInstance;

	return service;
}

UserProfileService.$inject = ["$http", "ConstantsApp"];
angular.module("meuControleHorasApp").factory("UserProfileService", UserProfileService);

// private functions
function getInstance() {
    var profile = {};

    profile.name = null;
    profile.email = null;
    profile.birthDate = null;
    profile.gender = null;
    profile.avatar = null;
    profile.company = null;
    profile.profession = null;
    profile.valorHora = null;
    profile.horasPorMes = null;
    profile.maxHorasPorMes = null;
    profile.address = {};
    profile.address.cep = null;
    profile.address.logradouro = null;
    profile.address.bairro = null;
    profile.address.cidade = null;
    profile.address.uf = null;

    return profile;
}