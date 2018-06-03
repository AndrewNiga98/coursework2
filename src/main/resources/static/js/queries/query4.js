let app = angular.module("coursework", []);

app.controller("AppCtrl", function ($http, $scope) {

    $scope.sortType     = 'name';
    $scope.sortReverse  = false;

    $scope.entries = [];

    let agreementId=1;

    $http.get('/api/query4?agreement_id='+agreementId).then(function (response){
        $scope.entries = response.data;

        for (let i = 0; i < $scope.entries.length; i++){
            if ($scope.entries[i].subcontract === 1) {
                $scope.entries[i].subcontract = "✔️"
            } else {
                $scope.entries[i].subcontract = "❌"
            }
        }

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
    });

    $scope.update_request = function add() {
        let departmentIndex = document.getElementById("Agreement").selectedIndex;
        agreementId = document.getElementById("Agreement").options[departmentIndex].value;

        $http.get('/api/query4?agreement_id='+agreementId).then(function (response){
            $scope.entries = response.data;

            for (let i = 0; i < $scope.entries.length; i++){
                if ($scope.entries[i].subcontract === 1) {
                    $scope.entries[i].subcontract = "✔️"
                } else {
                    $scope.entries[i].subcontract = "❌"
                }
            }
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


