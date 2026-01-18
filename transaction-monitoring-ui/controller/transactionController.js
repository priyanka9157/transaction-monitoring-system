app.controller("TransactionController", function ($scope, TransactionService) {
    $scope.transactions = [];

    TransactionService.getTransactions().then(function (response) {
        $scope.transactions = response.data;
    });
});
