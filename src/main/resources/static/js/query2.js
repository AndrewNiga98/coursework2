let app = angular.module("coursework", []);

app.controller("AppCtrl", function ($http, $scope) {

    $scope.sortType     = 'name';
    $scope.sortReverse  = false;

    $scope.entries = [];
    $http.get('/api/areas').then(function (response){
        $scope.entries = response.data;
        console.log(response);
    });



    this.changeSort = function changeSort(column) {
        if ($scope.sortType === column) $scope.sortReverse = !$scope.sortReverse;
        else $scope.sortReverse = false;
        $scope.sortType = column;
    }
});