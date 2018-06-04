let app = angular.module("coursework", []);

app.controller("AppCtrl", function ($http, $scope) {

    $scope.sortType     = 'name';
    $scope.sortReverse  = false;

    $scope.entries = [];
    $http.get('/api/objects').then(function (response){
        $scope.entries = response.data;
    });

    this.del_entry = function del(id) {
        $http.get('/api/objects/del?id='+id).then(function (response){
            window.location.reload();
            window.alert("Об'єкт було успішно видалено!");
        });
    };

    this.start_insert_entry = function add() {
        $http.get('/api/type_of_object').then(function (response){
            let data = response.data;
            data.sort(function (a, b) { return a.id - b.id; });
            let selector = document.getElementById("TypeOfObject");
            $(selector).empty();
            for (let i = 0; i < data.length; i++) {
                let option = document.createElement("option");
                option.text = data[i].name;
                option.value = data[i].id;
                selector.add(option);
            }
        });
        $http.get('/api/areas').then(function (response){
            let data = response.data;
            data.sort(function (a, b) { return a.id - b.id; });
            let selector = document.getElementById("Area");
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
        let name = document.getElementById("Name").value;
        let typeIndex = document.getElementById("TypeOfObject").selectedIndex;
        let typeOfObjectId = document.getElementById("TypeOfObject").options[typeIndex].value;
        let areaIndex = document.getElementById("Area").selectedIndex;
        let areasId = document.getElementById("Area").options[areaIndex].value;

        $http.get('/api/objects/insert?name='+name+'&typeId='+typeOfObjectId+'&areaId='+areasId).then(function (response){
            window.location.reload();
            window.alert("Об'єкт було успішно додано!");
        });
    };

    let thisId;

    this.start_update_entry = function upd(id, name, typeOfId, areasId) {
        thisId = id;
        let typeIndex;
        $http.get('/api/type_of_object').then(function (response){
            let data = response.data;
            data.sort(function (a, b) { return a.id - b.id; });
            let selector = document.getElementById("TypeOfObjectUPD");
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

            document.getElementById("TypeOfObjectUPD").selectedIndex = typeIndex;
        });

        let areaIndex;
        $http.get('/api/areas').then(function (response){
            let data = response.data;
            data.sort(function (a, b) { return a.id - b.id; });
            let selector = document.getElementById("AreaUPD");
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

            document.getElementById("AreaUPD").selectedIndex = areaIndex;
        });
        document.getElementById("NameUDP").value = name;
    };

    this.update_entry = function upd() {
        let name = document.getElementById("NameUPD").value;
        let typeIndex = document.getElementById("TypeOfObjectUPD").selectedIndex;
        let typeOfObjectId = document.getElementById("TypeOfObjectUPD").options[typeIndex].value;
        let areaIndex = document.getElementById("AreaUPD").selectedIndex;
        let areaId = document.getElementById("AreaUPD").options[areaIndex].value;


        $http.get('/api/objects/update?id='+thisId+'&name='+name+'&typeId='+typeOfObjectId+'&areaId='+areaId).then(function (response){
            window.location.reload();
            window.alert("Об'єкт було успішно змінено!");
        });
    };

    this.changeSort = function changeSort(column) {
        if ($scope.sortType === column) $scope.sortReverse = !$scope.sortReverse;
        else $scope.sortReverse = false;
        $scope.sortType = column;
    }
});


