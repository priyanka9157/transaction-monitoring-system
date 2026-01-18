app.service("MonitoringService", function ($http) {
    this.getRiskTransactions = function () {
        return $http.get("http://localhost:8082/api/monitoring");
    };
});
