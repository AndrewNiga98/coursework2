let app = angular.module("coursework", []);

app.controller("AppCtrl", function ($http, $scope) {

    $scope.sortType     = 'name';
    $scope.sortReverse  = false;

    $scope.entries = [];

    let objectId = 0;

    $http.get('/request/request6?objectId='+objectId).then(function (response){
        $scope.entries = response.data;

        $http.get('/api/objects').then(function (response){
            let data = response.data;
            data.sort(function (a, b) { return a.id - b.id; });
            let selector = document.getElementById("Object");
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
        let objectIndex = document.getElementById("Object").selectedIndex;
        objectId = document.getElementById("Object").options[objectIndex].value;

        $http.get('/request/request6?objectId='+objectId).then(function (response){
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