var _urlListAccessControlled = [];

_urlListAccessControlled.push("app/view/home.html");
_urlListAccessControlled.push("app/view/login.html");
_urlListAccessControlled.push("app/view/cadastro.html");

angular.module("meuControleHorasApp").constant("ConstantsApp", {
    tokenKey: "JWT_TOKEN",
    appContextUrl: "/MeuControleHoras/",
    urlListAccessControlled: _urlListAccessControlled
});