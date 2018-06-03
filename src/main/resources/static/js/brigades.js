let app = angular.module("coursework", []);

app.controller("AppCtrl", function ($http, $scope) {

    $scope.sortType     = 'name';
    $scope.sortReverse  = false;

    $scope.entries = [];
    $http.get('/api/brigades').then(function (response){
        $scope.entries = response.data;
    });

    this.del_entry = function del(id) {
        $http.get('/api/brigades/del?id='+id).then(function (response){
            window.location.reload();
            window.alert("Бригаду було успішно видалено!");
        });
    };

    this.start_insert_entry = function add() {
        $http.get('/api/construction_technology').then(function (response){
            let data = response.data;
            data.sort(function (a, b) { return a.id - b.id; });
            let selector = document.getElementById("ConstructionTechnology");
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
            let selector = document.getElementById("ObjectName");
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
        let name = document.getElementById("Brigadier").value;
        let technologyIndex = document.getElementById("ConstructionTechnology").selectedIndex;
        let technologyId = document.getElementById("ConstructionTechnology").options[technologyIndex].value;
        let objectIndex = document.getElementById("ObjectName").selectedIndex;
        let objectId = document.getElementById("ObjectName").options[objectIndex].value;

        $http.get('/api/brigades/insert?brigadier='+name+'&constructionTechnologyId='+technologyId+'&objectId='+objectId).then(function (response){
            window.location.reload();
            window.alert("Бригаду було успішно додано!");
        });
    };

    let thisId;

    this.start_update_entry = function upd(id, name, technologyId, objectId) {
        thisId = id;
        let technologyIndex;
        $http.get('/api/construction_technology').then(function (response){
            let data = response.data;
            data.sort(function (a, b) { return a.id - b.id; });
            let selector = document.getElementById("ConstructionTechnologyUPD");
            $(selector).empty();
            for (let i = 0; i < data.length; i++) {
                let option = document.createElement("option");
                option.text = data[i].name;
                option.value = data[i].id;
                if(data[i].id === technologyId)
                {
                    technologyIndex = i;

                }
                selector.add(option);
            }

            document.getElementById("ConstructionTechnologyUPD").selectedIndex = technologyIndex;
        });

        let objectIndex;
        $http.get('/api/objects').then(function (response){
            let data = response.data;
            data.sort(function (a, b) { return a.id - b.id; });
            let selector = document.getElementById("ObjectNameUPD");
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

            document.getElementById("ObjectNameUPD").selectedIndex = objectIndex;
        });



        document.getElementById("BrigadierUPD").value = name;
    };

    this.update_entry = function upd() {
        let name = document.getElementById("BrigadierUPD").value;
        let technologyIndex = document.getElementById("ConstructionTechnologyUPD").selectedIndex;
        let technologyId = document.getElementById("ConstructionTechnologyUPD").options[technologyIndex].value;
        let objectIndex = document.getElementById("ObjectNameUPD").selectedIndex;
        let objectId = document.getElementById("ObjectNameUPD").options[objectIndex].value;


        $http.get('/api/brigades/update?id='+thisId+'&brigadier='+name+'&constructionTechnologyId='+technologyId+'&objectId='+objectId).then(function (response){
            window.location.reload();
            window.alert("Бригаду було успішно змінено!");
        });
    };

    this.changeSort = function changeSort(column) {
        if ($scope.sortType === column) $scope.sortReverse = !$scope.sortReverse;
        else $scope.sortReverse = false;
        $scope.sortType = column;
    }
});


