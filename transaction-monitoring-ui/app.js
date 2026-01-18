var app = angular.module("transactionApp", ["ngRoute"]);

app.config(function ($routeProvider) {
    $routeProvider
        .when("/transactions", {
            templateUrl: "views/transactions.html",
            controller: "TransactionController"
        })
        .when("/monitoring", {
            templateUrl: "views/monitoring.html",
            controller: "MonitoringController"
        })
        .when("/alerts", {
            templateUrl: "views/alerts.html",
            controller: "AlertController"
        })
        .otherwise({
            redirectTo: "/transactions"
        });
});
