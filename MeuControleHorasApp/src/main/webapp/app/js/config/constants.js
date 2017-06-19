var _urlListAccessControlled = [];

_urlListAccessControlled.push("app/view/dashboard.html");

angular.module("meuControleHorasApp").constant("ConstantsApp", {
    tokenKey: "JWT_TOKEN",
    appContextUrl: "/MeuControleHoras/",
    urlListAccessControlled: _urlListAccessControlled
});