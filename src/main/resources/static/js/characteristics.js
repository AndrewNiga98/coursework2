let app = angular.module("coursework", []);

app.controller("AppCtrl", function ($http, $scope) {

    $scope.sortType     = 'name';
    $scope.sortReverse  = false;

    $scope.entries = [];
    $http.get('/api/characteristics').then(function (response){
        $scope.entries = response.data;
    });

    this.del_entry = function del(id) {
        $http.get('/api/characteristics/del?id='+id).then(function (response){
            window.location.reload();
            window.alert('Характеристику було успішно видалено!');
        });
    };

    this.start_insert_entry = function add() {
    };

    this.insert_entry = function add() {
        let name = document.getElementById("Name").value;

        $http.get('/api/characteristics/insert?name='+name).then(function (response){
            window.location.reload();
            window.alert('Характеристику було успішно додано!');
        });
    };

    let thisId;

    this.start_update_entry = function upd(id, name) {
        thisId = id;
        document.getElementById("NameUPD").value = name;
    };

    this.update_entry = function upd() {
        let name = document.getElementById("NameUPD").value;

        $http.get('/api/characteristics/update?id='+thisId+'&name='+name).then(function (response){
            window.location.reload();
            window.alert('Характеристику було успішно змінено!');
        });
    };

    this.changeSort = function changeSort(column) {
        if ($scope.sortType === column) $scope.sortReverse = !$scope.sortReverse;
        else $scope.sortReverse = false;
        $scope.sortType = column;
    }
});


