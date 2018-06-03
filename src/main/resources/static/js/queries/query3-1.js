let app = angular.module("coursework", []);

app.controller("AppCtrl", function ($http, $scope) {

    $scope.sortType     = 'name';
    $scope.sortReverse  = false;

    $scope.entries = [];

    let date = 0;
    /*
    $http.get('/api/query3-1?date='+date).then(function (response){
        $scope.entries = response.data;

    });
    */

    $scope.update_request = function add() {
        date = document.getElementById("Date").value;

        $http.get('/api/query3-1?date='+date).then(function (response){
            $scope.entries = response.data;
        });
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


