var app = angular.module('categoriaModule',[]);
app.controller('categoriaControl',function($scope,$http) {
	
	urlcategoria = 'http://localhost:8080/DS2016-2Ecommerce/rs/categoria';
	
	$scope.salvar = function() {
		if ($scope.categoria.idCategoria == ''){
			$http.post(urlcategoria,$scope.categoria).success(function(categorias){
				$scope.categorias.push($scope.categoria);
				$scope.novo();
			}).error(function (erro){
					alert(erro);
			});
		} else {
			$http.put(urlcategoria,$scope.categoria).success(function(categoria){
				$scope.pesquisar();
				$scope.novo();
			}).error(function (erro){
				alert(erro);
			});
		}
	}
	
	$scope.montaMensagemErro = function(listaErro) {
		$scope.mensagens = [];
		$scope.mensagens.push('Falha de validação retornada do servidor');
		angular.forEach(listaErro, function(value, key){
			 $scope.mensagens.push(value.message);
		});
	}
	
	$scope.pesquisar = function() {
		$http.get(urlcategoria).success(function (categorias) {
			$scope.categorias = categorias;
		}).error(function (erro) {
			alert(erro);
		});
	}
	
	$scope.excluir = function() {
		if ($scope.categoria.idCategoria == ''){
			alert('Selecione uma Categoria');
	} else {
		$http.delete(urlcategoria+"/"+$scope.categoria.idCategoria).success(function() {
			$scope.categorias.splice($scope.categorias.indexOf($scope.categoria), 1);	
			$scope.novo();
			$scope.mensagens.push('Categoria excluído com sucesso');
		}).error(function (erro) {
			//$scope.mensagens.push('Erro ao salvar Aluno: '+JSON.stringify(erro));
			$scope.montaMensagemErro(erro.parameterViolations);
		});
	}
		
		
		//$scope.categorias.splice($scope.categorias.indexOf($scope.categoria), 1);	
		//$scope.novo();  		
	}
	
	$scope.novo = function () { 
		$scope.categoria = {};
		$scope.mensagens=[];
	}; 	
	
	$scope.seleciona = function (categoria) {
		$scope.categoria = categoria; 								  
	};	
	
	$scope.pesquisar();
	$scope.novo();
	
});