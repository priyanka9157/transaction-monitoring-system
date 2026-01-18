app.service("TransactionService", function ($http) {
    this.getTransactions = function () {
        return $http.get("http://localhost:8080/api/transactions");
    };
});
