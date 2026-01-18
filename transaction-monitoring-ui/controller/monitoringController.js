app.controller("MonitoringController", function ($scope, MonitoringService) {
    $scope.monitored = [];

    MonitoringService.getRiskTransactions().then(function (response) {
        $scope.monitored = response.data;
    });
});
