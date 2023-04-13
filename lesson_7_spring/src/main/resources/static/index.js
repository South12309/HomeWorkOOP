angular.module('app',[]).controller('indexController', function($scope, $http){

    const contextPath = 'http://localhost:8080/app/api/v1/students';

    $scope.fillTable = function() {
        $http.get(contextPath)
            .then(function(response) {
                $scope.studentList = response.data;
            });
    };

    $scope.add = function(){
        $http.post(contextPath, $scope.newStudent)
            .then(function(response) {
                $scope.fillTable();
            });
    };

    $scope.delete = function(id){
        $http.delete(contextPath + '/' + id)
            .then(function(response) {
                $scope.fillTable();
            });
    };

    $scope.edit = function(){
        $http.put(contextPath, $scope.editStudent)
            .then(function(response) {
                $scope.fillTable();
            });
    };

    $scope.fillTable();

});