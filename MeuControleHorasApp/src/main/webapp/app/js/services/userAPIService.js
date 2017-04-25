function UserAPIService($http) {

    var _getUser = function(email) {
        return $http.get("/usuario/" + email);
    };

    var _createUser = function(user) {
        return $http.post("/usuario/cadastro", user);
    };

    var _getAllUsers = function() {
        return $http.get("/MeuControleHoras/usuarios");
    };

    return {
        getUser: _getUser,
        createUser: _createUser,
        getAllUsers: _getAllUsers
    };
}

angular.module("meuControleHorasApp").service("UserAPIService", UserAPIService);