app.service("AlertService", function ($http) {
    this.getAlerts = function () {
        return $http.get("http://localhost:8083/api/alerts");
    };
});
