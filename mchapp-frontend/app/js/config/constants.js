var _urlListAccessControlled = [];

_urlListAccessControlled.push("views/dashboard.html");

angular.module("meuControleHorasApp").constant("ConstantsApp", {
    tokenKey: "JWT_TOKEN",
    appContextUrl: "http://localhost:8083/",
    addressWS: "https://viacep.com.br/ws/",
    urlListAccessControlled: _urlListAccessControlled
});