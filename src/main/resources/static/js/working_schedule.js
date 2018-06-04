let app = angular.module("coursework", []);

app.controller("AppCtrl", function ($http, $scope) {

    $scope.sortType     = 'name';
    $scope.sortReverse  = false;

    $scope.entries = [];
    $http.get('/api/working_schedule').then(function (response){
        $scope.entries = response.data;
    });

    this.del_entry = function del(id) {
        $http.get('/api/working_schedule/del?id='+id).then(function (response){
            window.location.reload();
            window.alert("Робочий графік було успішно видалено!");
        });
    };

    this.start_insert_entry = function add() {
        $http.get('/api/construction_technology').then(function (response){
            let data = response.data;
            data.sort(function (a, b) { return a.id - b.id; });
            let selector = document.getElementById("Technology");
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

        $http.get('/api/machinery').then(function (response){
            let data = response.data;
            data.sort(function (a, b) { return a.id - b.id; });
            let selector = document.getElementById("Machinery");
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
        let start = document.getElementById("Start").value;
        let end = document.getElementById("End").value;
        let technologyIndex = document.getElementById("Technology").selectedIndex;
        let technologyId = document.getElementById("Technology").options[technologyIndex].value;
        let objectIndex = document.getElementById("Object").selectedIndex;
        let objectId = document.getElementById("Object").options[objectIndex].value;
        let machineryIndex = document.getElementById("Machinery").selectedIndex;
        let machineryId = document.getElementById("Machinery").options[machineryIndex].value;

        $http.get('/api/working_schedule/insert?start_of_job='+start+'&end='+end+'&constructionTechnologyId='+technologyId+'&objectId='+objectId+'&machineryId='+machineryId).then(function (response){
            window.location.reload();
            window.alert('Графік було успішно додано!');
        });
    };

    let thisId;

    this.start_update_entry = function upd(id, start, end, constructionId, objectId, machineryId) {
        thisId = id;
        let constructionIndex;
        $http.get('/api/construction_technology').then(function (response){
            let data = response.data;
            data.sort(function (a, b) { return a.id - b.id; });
            let selector = document.getElementById("TechnologyUPD");
            $(selector).empty();
            for (let i = 0; i < data.length; i++) {
                let option = document.createElement("option");
                option.text = data[i].name;
                option.value = data[i].id;
                if(data[i].id === constructionId)
                {
                    constructionIndex = i;

                }
                selector.add(option);
            }

            document.getElementById("TechnologyUPD").selectedIndex = constructionIndex;
        });
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
        let machineryIndex;
        $http.get('/api/machinery').then(function (response){
            let data = response.data;
            data.sort(function (a, b) { return a.id - b.id; });
            let selector = document.getElementById("MachineryUPD");
            $(selector).empty();
            for (let i = 0; i < data.length; i++) {
                let option = document.createElement("option");
                option.text = data[i].name;
                option.value = data[i].id;
                if(data[i].id === machineryId)
                {
                    machineryIndex = i;

                }
                selector.add(option);
            }

            document.getElementById("MachineryUPD").selectedIndex = machineryIndex;
        });


    };

    this.update_entry = function upd() {
        let start = document.getElementById("StartUPD").value;
        let end = document.getElementById("EndUPD").value;
        let constructionIndex = document.getElementById("TechnologyUPD").selectedIndex;
        let constructionId = document.getElementById("TechnologyUPD").options[constructionIndex].value;
        let objectIndex = document.getElementById("ObjectUPD").selectedIndex;
        let objectId = document.getElementById("ObjectUPD").options[objectIndex].value;
        let machineryIndex = document.getElementById("MachineryUPD").selectedIndex;
        let machineryId = document.getElementById("MachineryUPD").options[machineryIndex].value;


        $http.get('/api/working_schedule/update?id='+thisId+'&start_of_job='+start+'&end='+end+'&constructionTechnologyId='+constructionId+'&objectId='+objectId+'&machineryId='+machineryId).then(function (response){
            window.location.reload();
            window.alert("Графік було успішно змінено!");
        });
    };

    this.changeSort = function changeSort(column) {
        if ($scope.sortType === column) $scope.sortReverse = !$scope.sortReverse;
        else $scope.sortReverse = false;
        $scope.sortType = column;
    }
});


