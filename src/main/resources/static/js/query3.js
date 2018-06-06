let app = angular.module("coursework", []);

app.controller("AppCtrl", function ($http, $scope) {

    $scope.sortType     = 'name';
    $scope.sortReverse  = false;

    $scope.entries = [];

    let managementId = 0;

    $http.get('/request/request3?managementId='+managementId).then(function (response){
        $scope.entries = response.data;

        $http.get('/api/building_management').then(function (response){
            let data = response.data;
            data.sort(function (a, b) { return a.id - b.id; });
            let selector = document.getElementById("Management");
            $(selector).empty();
            for (let i = 0; i < data.length; i++) {
                let option = document.createElement("option");
                option.text = data[i].name;
                option.value = data[i].id;
                selector.add(option);
            }
        });
    });


    $scope.update_request = function add() {
        let managementIndex = document.getElementById("Management").selectedIndex;
        managementId = document.getElementById("Management").options[managementIndex].value;

        $http.get('/request/request3?managementId='+managementId).then(function (response){
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