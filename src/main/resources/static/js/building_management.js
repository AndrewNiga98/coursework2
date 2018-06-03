let app = angular.module("coursework", []);

app.controller("AppCtrl", function ($http, $scope) {

    $scope.sortType     = 'name';
    $scope.sortReverse  = false;

    $scope.entries = [];
    $http.get('/api/building_management').then(function (response){
        $scope.entries = response.data;
    });

    this.del_entry = function del(id) {
        $http.get('/api/building_management/del?id='+id).then(function (response){
            window.location.reload();
            window.alert('Буд. ділянку було успішно видалено!');
        });
    };

    this.start_insert_entry = function add() {
    };

    this.insert_entry = function add() {
        let name = document.getElementById("Name").value;
        let chief_name = document.getElementById("Chief").value;

        $http.get('/api/building_management/insert?name='+name+'&chief='+chief_name).then(function (response){
            window.location.reload();
            window.alert('Буд. ділянку було успішно додано!');
        });
    };

    let thisId;

    this.start_update_entry = function upd(id, name, chief) {
        thisId = id;
        document.getElementById("NameUPD").value = name;
        document.getElementById("ChiefUPD").value = chief;
    };

    this.update_entry = function upd() {
        let name = document.getElementById("NameUPD").value;
        let chief_name = document.getElementById("ChiefUPD").value;

        $http.get('/api/building_management/update?id='+thisId+'&name='+name+'&chief='+chief_name).then(function (response){
            window.location.reload();
            window.alert('Буд. ділянку було успішно змінено!');
        });
    };

    this.changeSort = function changeSort(column) {
        if ($scope.sortType === column) $scope.sortReverse = !$scope.sortReverse;
        else $scope.sortReverse = false;
        $scope.sortType = column;
    }
});


