let app = angular.module("coursework", []);

app.controller("AppCtrl", function ($http, $scope) {

    $scope.sortType     = 'name';
    $scope.sortReverse  = false;

    $scope.entries = [];
    $http.get('/api/report').then(function (response){
        $scope.entries = response.data;
    });

    this.del_entry = function del(id) {
        $http.get('/api/report/del?id='+id).then(function (response){
            window.location.reload();
            window.alert("Звіт було успішно видалено!");
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


        $http.get('/api/material').then(function (response){
            let data = response.data;
            data.sort(function (a, b) { return a.id - b.id; });
            let selector = document.getElementById("Material");
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
        let amount = document.getElementById("Amount").value;
        let date = document.getElementById("Date").value;
        let materialIndex = document.getElementById("Material").selectedIndex;
        let materialId = document.getElementById("Material").options[materialIndex].value;
        let objectIndex = document.getElementById("Object").selectedIndex;
        let objectId = document.getElementById("Object").options[objectIndex].value;

        $http.get('/api/report/insert?amount='+amount+'&date='+date+'&materialId='+materialId+'&objectId='+objectId).then(function (response){
            window.location.reload();
            window.alert("Звіт було успішно додано!");
        });
    };

    let thisId;

    this.start_update_entry = function upd(id, name, typeOfId, areasId) {
        thisId = id;

        let areaIndex;
        $http.get('/api/objects').then(function (response){
            let data = response.data;
            data.sort(function (a, b) { return a.id - b.id; });
            let selector = document.getElementById("ObjectUPD");
            $(selector).empty();
            for (let i = 0; i < data.length; i++) {
                let option = document.createElement("option");
                option.text = data[i].name;
                option.value = data[i].id;
                if(data[i].id === areasId)
                {
                    areaIndex = i;

                }
                selector.add(option);
            }

            document.getElementById("ObjectUPD").selectedIndex = areaIndex;
        });
        let typeIndex;
        $http.get('/api/material').then(function (response){
            let data = response.data;
            data.sort(function (a, b) { return a.id - b.id; });
            let selector = document.getElementById("MaterialUPD");
            $(selector).empty();
            for (let i = 0; i < data.length; i++) {
                let option = document.createElement("option");
                option.text = data[i].name;
                option.value = data[i].id;
                if(data[i].id === typeOfId)
                {
                    typeIndex = i;

                }
                selector.add(option);
            }

            document.getElementById("MaterialUPD").selectedIndex = typeIndex;
        });



        document.getElementById("AmountUPD").value = name;
        document.getElementById("DateUPD")
    };

    this.update_entry = function upd() {
        let amount = document.getElementById("AmountUPD").value;
        let date = document.getElementById("DateUPD").value;
        let objectIndex = document.getElementById("ObjectUPD").selectedIndex;
        let objectId = document.getElementById("ObjectUPD").options[objectIndex].value;
        let materialIndex = document.getElementById("MaterialUPD").selectedIndex;
        let materialId = document.getElementById("MaterialUPD").options[materialIndex].value;


        $http.get('/api/report/update?id='+thisId+'&amount='+amount+'&date='+date+'&objectId='+objectId+'&materialId='+materialId).then(function (response){
            window.location.reload();
            window.alert("Звіт було успішно змінено!");
        });
    };

    this.changeSort = function changeSort(column) {
        if ($scope.sortType === column) $scope.sortReverse = !$scope.sortReverse;
        else $scope.sortReverse = false;
        $scope.sortType = column;
    }
});


