let app = angular.module("coursework", []);

app.controller("AppCtrl", function ($http, $scope) {

    $scope.sortType     = 'project.name';
    $scope.sortReverse  = false;

    $scope.entries = [];

    let equipmentId = 0;

    $http.get('/api/query11?equipment_id='+equipmentId).then(function (response){
        $scope.entries = response.data;

        for (let i = 0; i < $scope.entries.length; i++){
            if ($scope.entries[i].project.subcontract === 1) {
                $scope.entries[i].project.subcontract = "✔️"
            } else {
                $scope.entries[i].project.subcontract = "❌"
            }
        }

        $http.get('/api/equipment').then(function (response){
            let data = response.data;
            data.sort(function (a, b) { return a.id - b.id; });
            let selector = document.getElementById("Equipment");
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
        let equipmentIndex = document.getElementById("Equipment").selectedIndex;
        equipmentId = document.getElementById("Equipment").options[equipmentIndex].value;

        $http.get('/api/query11?equipment_id='+equipmentId).then(function (response){
            $scope.entries = response.data;

            for (let i = 0; i < $scope.entries.length; i++){
                if ($scope.entries[i].project.subcontract === 1) {
                    $scope.entries[i].project.subcontract = "✔️"
                } else {
                    $scope.entries[i].project.subcontract = "❌"
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


