let app = angular.module("coursework", []);

app.controller("AppCtrl", function ($http, $scope) {

    $scope.sortType     = 'name';
    $scope.sortReverse  = false;

    $scope.entries = [];
    $http.get('/api/subordinate_personnel').then(function (response){
        $scope.entries = response.data;
    });

    this.del_entry = function del(id) {
        $http.get('/api/subordinate_personnel/del?id='+id).then(function (response){
            window.location.reload();
            window.alert("Персонал  було успішно видалено!");
        });
    };

    this.start_insert_entry = function add() {
        $http.get('/api/building_management').then(function (response){
            let data = response.data;
            data.sort(function (a, b) { return a.id - b.id; });
            let selector = document.getElementById("BuildingManagement");
            $(selector).empty();
            for (let i = 0; i < data.length; i++) {
                let option = document.createElement("option");
                option.text = data[i].name;
                option.value = data[i].id;
                selector.add(option);
            }
        });
        $http.get('/api/engineering_stuff').then(function (response){
            let data = response.data;
            data.sort(function (a, b) { return a.id - b.id; });
            let selector = document.getElementById("EngineeringStuff");
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
        let position = document.getElementById("Position").value;
        let buildingIndex = document.getElementById("BuildingManagement").selectedIndex;
        let buildingId = document.getElementById("BuildingManagement").options[buildingIndex].value;
        let engineeringIndex = document.getElementById("EngineeringStuff").selectedIndex;
        let engineeringId = document.getElementById("EngineeringStuff").options[engineeringIndex].value;

        $http.get('/api/subordinate_personnel/insert?position='+position+'&buildingmanagementId='+buildingId+'&engineeringstuffId='+engineeringId).then(function (response){
            window.location.reload();
            window.alert("Персонал було успішно додано!");
        });
    };

    let thisId;

    this.start_update_entry = function upd(id, position, buildingId, engineeringId) {
        thisId = id;
        let buildingIndex;
        $http.get('/api/building_management').then(function (response){
            let data = response.data;
            data.sort(function (a, b) { return a.id - b.id; });
            let selector = document.getElementById("BuildingManagementUPD");
            $(selector).empty();
            for (let i = 0; i < data.length; i++) {
                let option = document.createElement("option");
                option.text = data[i].name;
                option.value = data[i].id;
                if(data[i].id === buildingId)
                {
                    buildingIndex = i;

                }
                selector.add(option);
            }

            document.getElementById("BuildingManagementUPD").selectedIndex = buildingIndex;
        });

        let engineeringIndex;
        $http.get('/api/engineering_stuff').then(function (response){
            let data = response.data;
            data.sort(function (a, b) { return a.id - b.id; });
            let selector = document.getElementById("EngineeringStuffUPD");
            $(selector).empty();
            for (let i = 0; i < data.length; i++) {
                let option = document.createElement("option");
                option.text = data[i].name;
                option.value = data[i].id;
                if(data[i].id === engineeringId)
                {
                    engineeringIndex = i;

                }
                selector.add(option);
            }

            document.getElementById("EngineeringStuffUPD").selectedIndex = engineeringIndex;
        });



        document.getElementById("PositionUPD").value = position;
    };

    this.update_entry = function upd() {
        let position = document.getElementById("PositionUPD").value;
        let buildingIndex = document.getElementById("BuildingManagementUPD").selectedIndex;
        let buildingId = document.getElementById("BuildingManagementUPD").options[buildingIndex].value;
        let engineeringIndex = document.getElementById("EngineeringStuffUPD").selectedIndex;
        let engineeringId = document.getElementById("EngineeringStuffUPD").options[engineeringIndex].value;


        $http.get('/api/subordinate_personnel/update?id='+thisId+'&position='+position+'&buildingmanagementId='+buildingId+'&engineeringstuffId='+engineeringId).then(function (response){
            window.location.reload();
            window.alert("Персонал було успішно змінено!");
        });
    };

    this.changeSort = function changeSort(column) {
        if ($scope.sortType === column) $scope.sortReverse = !$scope.sortReverse;
        else $scope.sortReverse = false;
        $scope.sortType = column;
    }
});


