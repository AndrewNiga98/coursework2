let app = angular.module("coursework", []);

app.controller("AppCtrl", function ($http, $scope) {

    $scope.sortType     = 'name';
    $scope.sortReverse  = false;

    $scope.entries = [];
    $http.get('/api/estimate').then(function (response){
        $scope.entries = response.data;
    });

    this.del_entry = function del(id) {
        $http.get('/api/estimate/del?id='+id).then(function (response){
            window.location.reload();
            window.alert("Кошторис було успішно видалено!");
        });
    };

    this.start_insert_entry = function add() {
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
    };

    this.insert_entry = function add() {
        let amount = document.getElementById("Amount").value;
        let materialIndex = document.getElementById("Material").selectedIndex;
        let materialId = document.getElementById("Material").options[materialIndex].value;
        let objectIndex = document.getElementById("Object").selectedIndex;
        let objectId = document.getElementById("Object").options[objectIndex].value;

        $http.get('/api/estimate/insert?amount='+amount+'&materialId='+materialId+'&objectId='+objectId).then(function (response){
            window.location.reload();
            window.alert("Кошторис було успішно додано!");
        });
    };

    let thisId;

    this.start_update_entry = function upd(id, name, typeOfId, areasId) {
        thisId = id;
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



        document.getElementById("AmountUPD").value = name;
    };

    this.update_entry = function upd() {
        let amount = document.getElementById("AmountUPD").value;
        let materialIndex = document.getElementById("MaterialUPD").selectedIndex;
        let materiald = document.getElementById("MaterialUPD").options[materialIndex].value;
        let objectIndex = document.getElementById("ObjectUPD").selectedIndex;
        let objectId = document.getElementById("ObjectUPD").options[objectIndex].value;


        $http.get('/api/estimate/update?id='+thisId+'&amount='+amount+'&materialId='+materiald+'&areaId='+objectId).then(function (response){
            window.location.reload();
            window.alert("Кошторис було успішно змінено!");
        });
    };

    this.changeSort = function changeSort(column) {
        if ($scope.sortType === column) $scope.sortReverse = !$scope.sortReverse;
        else $scope.sortReverse = false;
        $scope.sortType = column;
    }
});


