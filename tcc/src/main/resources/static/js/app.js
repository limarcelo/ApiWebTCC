var picolApp = angular.module("picolApp", []);

picolApp.controller("loginController", function($scope, $http){
	$scope.usuario = "Jão";
	
	$http({
		  method: 'GET',
		  url: '/usuario/listar'
		}).then(function successCallback(response) {
		    console.log(reponse.data);
		    onsole.log(reponse.status);
		  }, function errorCallback(response) {
			    console.log(reponse.data);
			    console.log(reponse.status);
		  });
	
	
});


