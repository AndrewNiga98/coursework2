let app = angular.module("coursework", []);

app.controller("AppCtrl", function ($http, $scope) {

    $scope.sortType     = 'name';
    $scope.sortReverse  = false;

    $scope.entries = [];
    $http.get('/api/objects_characteristics').then(function (response){
        $scope.entries = response.data;
    });

    this.del_entry = function del(id) {
        $http.get('/api/objects_characteristics/del?id='+id).then(function (response){
            window.location.reload();
            window.alert("Характеристику було успішно видалено!");
        });
    };

    this.start_insert_entry = function add() {
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
        $http.get('/api/characteristics').then(function (response){
            let data = response.data;
            data.sort(function (a, b) { return a.id - b.id; });
            let selector = document.getElementById("Characteristic");
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
        let objectIndex = document.getElementById("Object").selectedIndex;
        let objectId = document.getElementById("Object").options[objectIndex].value;
        let characteristicIndex = document.getElementById("Characteristic").selectedIndex;
        let characteristicId = document.getElementById("Characteristic").options[characteristicIndex].value;
        let value = document.getElementById("value").value;
        $http.get('/api/objects_characteristics/insert?objectId='+objectId+'&characteristicId='+characteristicId+'&value='+value).then(function (response){
            window.location.reload();
            window.alert("Характеристику було успішно додано!");
        });
    };

    let thisId;

    this.start_update_entry = function upd(id, value, objectId, characteristicId) {
        thisId = id;
        let objectIndex;
        $http.get('/api/objects').then(function (response){
            let data = response.data;
            data.sort(function (a, b) { return a.id - b.id; });
            let selector = document.getElementById("ObjectUPD");
            $(selector).empty();
            for (let i = 0; i < data.length; i++) {
                let option = document.createElement("option");
                option.text = data[i].name;
                option.value = data[i].id;
                if(data[i].id === objectId)
                {
                    objectIndex = i;

                }
                selector.add(option);
            }

            document.getElementById("ObjectUPD").selectedIndex = objectIndex;
        });

        let characteristicIndex;
        $http.get('/api/characteristics').then(function (response){
            let data = response.data;
            data.sort(function (a, b) { return a.id - b.id; });
            let selector = document.getElementById("CharacteristicUPD");
            $(selector).empty();
            for (let i = 0; i < data.length; i++) {
                let option = document.createElement("option");
                option.text = data[i].name;
                option.value = data[i].id;
                if(data[i].id === characteristicId)
                {
                    characteristicIndex = i;

                }
                selector.add(option);
            }

            document.getElementById("CharacteristicUPD").selectedIndex = characteristicIndex;
        });
        document.getElementById("valueUPD").value = value;
    };

    this.update_entry = function upd() {
        let objectIndex = document.getElementById("ObjectUPD").selectedIndex;
        let objectId = document.getElementById("ObjectUPD").options[objectIndex].value;
        let characteristicIndex = document.getElementById("CharacteristicUPD").selectedIndex;
        let characteristicId = document.getElementById("CharacteristicUPD").options[characteristicIndex].value;
        let value = document.getElementById("valueUPD").value;



        $http.get('/api/objects_characteristics/update?id='+thisId+'&objectId='+objectId+'&characteristicId='+characteristicId+'&value='+value).then(function (response){
            window.location.reload();
            window.alert("Характеристику було успішно змінено!");
        });
    };

    this.changeSort = function changeSort(column) {
        if ($scope.sortType === column) $scope.sortReverse = !$scope.sortReverse;
        else $scope.sortReverse = false;
        $scope.sortType = column;
    }
});


