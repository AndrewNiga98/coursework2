let app = angular.module("coursework", []);

app.controller("AppCtrl", function ($http, $scope) {

    $scope.sortType     = 'name';
    $scope.sortReverse  = false;

    $scope.entries = [];
    $http.get('/api/employee').then(function (response){
        $scope.entries = response.data;
    });

    this.del_entry = function del(id) {
        $http.get('/api/employee/del?id='+id).then(function (response){
            window.location.reload();
            window.alert('Робітника було успішно видалено!');
        });
    };

    this.start_insert_entry = function add() {
        $http.get('/api/brigades').then(function (response){
            let data = response.data;
            data.sort(function (a, b) { return a.id - b.id; });
            let selector = document.getElementById("Brigade");
            $(selector).empty();
            for (let i = 0; i < data.length; i++) {
                let option = document.createElement("option");
                option.text = data[i].name;
                option.value = data[i].id;
                selector.add(option);
            }
        });
    };

    this.insert_entry = function add() {
        let name = document.getElementById("TheName").value;
        let position = document.getElementById("ThePosition").value;
        let brigadeIndex = document.getElementById("Brigade").selectedIndex;
        let brigadeId = document.getElementById("Brigade").options[brigadeIndex].value;
        $http.get('/api/employee/insert?name='+name+'&position='+position+'&brigadeId='+brigadeId).then(function (response) {
            window.location.reload();
            window.alert("Робітника було успішно додано");

        })
    };

    let thisId;

    this.start_update_entry = function upd(id, name, position, brigadeId) {
        thisId = id;
        let brigadeIndex;
        $http.get('/api/brigades').then(function (response){
            let data = response.data;
            data.sort(function (a, b) { return a.id - b.id; });
            let selector = document.getElementById("BrigadeUPD");
            $(selector).empty();
            for (let i = 0; i < data.length; i++) {
                let option = document.createElement("option");
                option.text = data[i].name;
                option.value = data[i].id;
                if(data[i].id === brigadeId)
                {
                    brigadeIndex = i;

                }
                selector.add(option);
            }

            document.getElementById("BrigadeUPD").selectedIndex = brigadeIndex;
        });

        document.getElementById("NameUPD").value = name;
        document.getElementById("PositionUPD").value = position;
    };

    this.update_entry = function upd() {
        let name = document.getElementById("NameUPD").value;
        let position = document.getElementById("PositionUPD").value;
        let brigadeIndex = document.getElementById("BrigadeUPD").selectedIndex;
        let brigadeId = document.getElementById("BrigadeUPD").options[brigadeIndex].value;

        $http.get('/api/employee/update?id='+thisId+'&name='+name+'&position='+position+'&brigadeId='+brigadeId).then(function (response){
            window.location.reload();
            window.alert('Робітника було успішно змінено!');
        });

    };

    this.changeSort = function changeSort(column) {
        if ($scope.sortType === column) $scope.sortReverse = !$scope.sortReverse;
        else $scope.sortReverse = false;
        $scope.sortType = column;
    }
});


