let app = angular.module("coursework", []);

app.controller("AppCtrl", function ($http, $scope) {

    $scope.sortType     = 'name';
    $scope.sortReverse  = false;

    $scope.entries = [];

    let areaId = 0;

    $http.get('/request/request4?areaId='+areaId).then(function (response){
        $scope.entries = response.data;

        $http.get('/api/areas').then(function (response){
            let data = response.data;
            data.sort(function (a, b) { return a.id - b.id; });
            let selector = document.getElementById("Area");
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
        let areaIndex = document.getElementById("Area").selectedIndex;
        areaId = document.getElementById("Area").options[areaIndex].value;

        $http.get('/request/request4?areaId='+areaId).then(function (response){
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