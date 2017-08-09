function uiRouterConfig(stateProvider, urlRouterProvider) {

    /////////////////////////// STATE: home
    var home = {};
    home.views = {};
    home.url = "/home";

    home.views[""] = {
        templateUrl: "views/headers/home-header.html"
    };
    home.views["homeBody@home"] = {
        templateUrl: "views/home.html",
        controller: "HomeController as ctrl"
    };

    stateProvider.state("home", home);


    /////////////////////////// STATE: home.login 
    var homeLogin = {};
    homeLogin.views = {};
    homeLogin.url = "/login";

    homeLogin.views["homeBody@home"] = {
        templateUrl: "views/login.html",
        controller: "LoginController as ctrl"
    };

    stateProvider.state("home.login", homeLogin);


    /////////////////////////// STATE: home.ativarConta 
    var homeAtivarConta = {};
    homeAtivarConta.views = {};
    homeAtivarConta.url = "/ativarConta";

    homeAtivarConta.views["homeBody@home"] = {
        templateUrl: "views/activate-account.html",
        controller: "ActivateAccountController as ctrl"   
    };

    stateProvider.state("home.ativarConta", homeAtivarConta);


    /////////////////////////// STATE: home.redefinirSenha 
    var homeRedefinirSenha = {};
    homeRedefinirSenha.views = {};
    homeRedefinirSenha.url = "/redefinirSenha";

    homeRedefinirSenha.views["homeBody@home"] = {
        templateUrl: "views/password-retrieve.html",
        controller: "PasswordRetrieveController as ctrl"
    };

    stateProvider.state("home.redefinirSenha", homeRedefinirSenha);


    /////////////////////////// STATE: home.cadastro
    var homeCadastro = {};
    homeCadastro.views = {};
    homeCadastro.url = "/cadastro";

    homeCadastro.views["homeBody@home"] = {
        templateUrl: "views/create-user.html",
        controller: "CreateUserController as ctrl"
    };

    stateProvider.state("home.cadastro", homeCadastro);


    /////////////////////////// STATE: erroServidor
    var erroServidor = {};
    erroServidor.url = "/erroServidor";
    erroServidor.templateUrl = "views/error-page.html";

    stateProvider.state("erroServidor", erroServidor);


    /////////////////////////// STATE: dashboard
    var dashboard = {};
    dashboard.views = {};
    dashboard.resolve = {};
    dashboard.url = "/dashboard";

    dashboard.resolve.userProfile = function(UserProfileService) {
        return UserProfileService.getProfile();
    };

    dashboard.views[""] = {
        templateUrl: "views/headers/dashboard-header.html",
        controller: "DashHeaderController as ctrl"
    };
    dashboard.views["dashboardBody@dashboard"] = {
        templateUrl: "views/dashboard.html",
        controller: "DashboardController as ctrl"
    };

    stateProvider.state("dashboard", dashboard);


    /////////////////////////// STATE: dashboard.profile 
    var dashboardProfile = {};
    dashboardProfile.views = {};
    dashboard.resolve = {};
    dashboardProfile.url = "/profile";

    dashboard.resolve.userProfile = function(UserProfileService) {
        return UserProfileService.getProfile();
    };

    dashboardProfile.views["dashboardBody@dashboard"] = {
        templateUrl: "views/profile.html",
        controller: "ProfileController as ctrl"
    };

    stateProvider.state("dashboard.profile", dashboardProfile);


    /////////////////////////// STATE: OTHERWISE 
    urlRouterProvider.otherwise('/home');
}

uiRouterConfig.$inject = ["$stateProvider", "$urlRouterProvider"];
angular.module("meuControleHorasApp").config(uiRouterConfig);