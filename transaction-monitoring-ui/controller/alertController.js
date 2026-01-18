app.controller("AlertController", function ($scope, AlertService) {
    $scope.alerts = [];

    AlertService.getAlerts().then(function (response) {
        $scope.alerts = response.data;
    });
});
