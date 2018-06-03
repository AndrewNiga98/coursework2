let app = angular.module("coursework", []);

app.controller("AppCtrl", function ($http, $scope) {

    $scope.sortType     = 'name';
    $scope.sortReverse  = false;

    $scope.entries = [];
    $http.get('/api/areas').then(function (response){
        $scope.entries = response.data;
    });

    this.del_entry = function del(id) {
        $http.get('/api/areas/del?id='+id).then(function (response){
            window.location.reload();
            window.alert('Ділянку було успішно видалено!');
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
    };

    this.insert_entry = function add() {
        let name = document.getElementById("Name").value;
        let chief_name = document.getElementById("Chief").value;
        let buildingIndex = document.getElementById("BuildingManagement").selectedIndex;
        let buildingId = document.getElementById("BuildingManagement").options[buildingIndex].value;

        $http.get('/api/areas/insert?name='+name+'&chief='+chief_name+'&buildingManagementId='+buildingId).then(function (response){
            window.location.reload();
            window.alert('Ділянку було успішно додано!');
        });
    };

    let thisId;

    this.start_update_entry = function upd(id, name, chief, buildingId) {
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

        document.getElementById("NameUPD").value = name;
        document.getElementById("ChiefUPD").value = chief;
    };

    this.update_entry = function upd() {
        let name = document.getElementById("NameUPD").value;
        let chief_name = document.getElementById("ChiefUPD").value;
        let buildingIndex = document.getElementById("BuildingManagementUPD").selectedIndex;
        let buildingId = document.getElementById("BuildingManagementUPD").options[buildingIndex].value;

        $http.get('/api/areas/update?id='+thisId+'&name='+name+'&chief='+chief_name+'&buildingManagementId='+buildingId).then(function (response){
            window.location.reload();
            window.alert('Ділянку було успішно змінено!');
        });
    };

    this.changeSort = function changeSort(column) {
        if ($scope.sortType === column) $scope.sortReverse = !$scope.sortReverse;
        else $scope.sortReverse = false;
        $scope.sortType = column;
    }
});


