var app = angular.module('categoriaModule',[]);
app.controller('categoriaControl',function($scope,$http) {
	
	urlcategoria = 'http://127.0.0.1:8080/DS2016-2Ecommerce/rs/categoria';
	
	$scope.salvar = function() {
		if ($scope.categoria.codigo == ''){
			$http.post(urlcategoria,$scope.categoria).success(function(categorias){
				$scope.categorias.push($scope.categoria);
				$scope.novo();
			}).error(function (erro){
					alert(erro);
			});
		} else {
			$http.put(urlcategoria,$scope.categoria).success(function(cliente){
				$scope.pesquisar();
				$scope.novo();
			}).error(function (erro){
				alert(erro);
			});
		}
	}
	
	$scope.pesquisar = function() {
		$http.get(urlcategoria).success(function (categorias) {
			$scope.categorias = categorias;
		}).error(function (erro) {
			alert(erro);
		});
	}
	
	$scope.excluir = function() {
		if ($scope.categoria.codigo == ''){
			alert('Selecione um cliente');
		} else {
			urlExcluir = urlcategoria + '/' + $scope.categoria;
			$http.delete(urlExcluir).success(function(){
				$scope.pesquisar();
				$scope.novo();
			}).error(function(erro) {
				alert(erro);
			});
		}
		
		//$scope.categorias.splice($scope.categorias.indexOf($scope.categoria), 1);	
		//$scope.novo();  		
	}
	
	$scope.novo = function () { 
		$scope.categoria = {};
	}; 	
	
	$scope.seleciona = function (categoria) {
		$scope.categoria = categoria; 								  
	};	
	
	$scope.pesquisar();
	
});