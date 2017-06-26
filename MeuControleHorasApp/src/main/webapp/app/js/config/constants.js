var _urlListAccessControlled = [];

_urlListAccessControlled.push("app/views/dashboard.html");

angular.module("meuControleHorasApp").constant("ConstantsApp", {
    tokenKey: "JWT_TOKEN",
    appContextUrl: "/MeuControleHoras/",
    urlListAccessControlled: _urlListAccessControlled
});