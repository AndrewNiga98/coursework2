let app = angular.module("coursework", []);

app.controller("AppCtrl", function ($http, $scope) {

    $scope.sortType     = 'project.name';
    $scope.sortReverse  = false;

    $scope.entries = [];

    let dateFrom = 0;
    let dateTo = 0;
    let typeId = 1;

    /*
    $http.get('/api/query8-1?date_from='+dateFrom+'&date_to='+dateTo+'&worker_id='+workerId).then(function (response){
        $scope.entries = response.data;

    });
    */

    $http.get('/api/specialties').then(function (response){
        let data = response.data;
        data.sort(function (a, b) { return a.id - b.id; });
        let selector = document.getElementById("Type");
        $(selector).empty();
        for (let i = 0; i < data.length; i++) {
            let option = document.createElement("option");
            option.text = data[i].name;
            option.value = data[i].id;
            selector.add(option);
        }
    });

    $scope.update_request = function add() {
        let typeIndex = document.getElementById("Type").selectedIndex;
        typeId = document.getElementById("Type").options[typeIndex].value;
        dateFrom = document.getElementById("DateFrom").value;
        dateTo = document.getElementById("DateTo").value;

        if (dateFrom && dateTo && dateFrom < dateTo) {
            $http.get('/api/query8-2?date_from=' + dateFrom + '&date_to=' + dateTo+'&type='+typeId).then(function (response) {
                $scope.entries = response.data;
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


