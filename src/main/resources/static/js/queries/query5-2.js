let app = angular.module("coursework", []);

app.controller("AppCtrl", function ($http, $scope) {

    $scope.sortType     = 'name';
    $scope.sortReverse  = false;

    $scope.entries = [];

    let dateFrom = 0;
    let dateTo = 0;
    /*
    $http.get('/api/query5-1?date='+date).then(function (response){
        $scope.entries = response.data;

    });
    */

    $scope.update_request = function add() {
        dateFrom = document.getElementById("DateFrom").value;
        dateTo = document.getElementById("DateTo").value;

        if (dateFrom && dateTo && dateFrom < dateTo) {
            $http.get('/api/query5-1?date_from='+dateFrom+'&date_to='+dateTo).then(function (response){
                $scope.entries = response.data;
                let item = {
                    price: 0
                };
                for (let i = 0; i < $scope.entries.length; i++) {
                    item.price += $scope.entries[i].price;
                }
                $scope.entries = [item];
            });
        }
    };

    this.changeSort = function changeSort(column) {
        if ($scope.sortType === column) $scope.sortReverse = !$scope.sortReverse;
        else $scope.sortReverse = false;
        $scope.sortType = column;
    }
});

function updateOutside() {
    let scope = angular.element('div[ng-controller="AppCtrl as ctrl"]').scope();
    scope.update_request();
    scope.$apply();
}


