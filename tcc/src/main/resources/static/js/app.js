var picolApp = angular.module("picolApp", []);

picolApp.controller("indexController", function($scope, $http){
	$scope.nome = "Jão";
	$scope.sobrenome = "da Silva";
	$scope.usuarios=[];
	$scope.usuario={};
	
	$scope.carregarUsuario = function(){
		$http({
			  method: 'GET',
			  url: '/usuario/listar'
			}).then(function successCallback(response) {
				$scope.usuarios= response.data;
			    console.log(response.status);
			  }, function errorCallback(response) {
			    console.log(response.data);
			    console.log(response.status);
		  });
	};
	
	$scope.cadastrarUsuario = function(){
		$http({
			  method: 'POST',
			  url: '/usuario/cadastrar',
			  data: cliente})
			  .then(function successCallback(response) {
				$scope.usuarios= response.data;
			    console.log(response.status);
			  }, function errorCallback(response) {
			    console.log(response.data);
			    console.log(response.status);
		  });
	};
	
	$scope.carregarUsuario();
	

});


