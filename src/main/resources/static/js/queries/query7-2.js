let app = angular.module("coursework", []);

app.controller("AppCtrl", function ($http, $scope) {

    $scope.sortType     = 'agreement.name';
    $scope.sortReverse  = false;

    $scope.entries = [];

    $http.get('/api/agreements?id=1').then(function (response){
        let data = response.data[0];

        $http.get('/api/query7-1?date_from='+data.from+'&date_to='+data.to).then(function (response){
            $scope.entries = response.data;
        });
    });

    $http.get('/api/agreements').then(function (response){
        let data = response.data;
        data.sort(function (a, b) { return a.id - b.id; });
        let selector = document.getElementById("Agreement");
        $(selector).empty();
        for (let i = 0; i < data.length; i++) {
            let option = document.createElement("option");
            option.text = data[i].name;
            option.value = data[i].id;
            selector.add(option);
        }
    });

    $scope.update_request = function add() {
        let agreementIndex = document.getElementById("Agreement").selectedIndex;
        let agreementId = document.getElementById("Agreement").options[agreementIndex].value;

        $http.get('/api/agreements?id='+agreementId).then(function (response){
            let data = response.data[0];

            $http.get('/api/query7-1?date_from='+data.from+'&date_to='+data.to).then(function (response){
                $scope.entries = response.data;
            });
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
