var app = angular.module('categoriaModule',['angularUtils.directives.dirPagination']);
app.controller('categoriaControl',function($scope,$http) {
	
	urlcategoria = 'http://localhost:8080/DS2016-2Ecommerce/rs/categoria';
	
	$scope.salvar = function() {
		$scope.mensagens = [];
		if ($scope.categoria.idCategoria == undefined || $scope.categoria.idCategoria == ''){
			if($scope.formPrincipal.$invalid){
				$scope.mensagens.push('Campo(s) Obrigatório(s) não Informado(s)!');
			}else{
				$http.post(urlcategoria,$scope.categoria).success(function(categoriaRetorno){
					$scope.categorias.push(categoriaRetorno);
					$scope.novo();
					$scope.mensagens.push('Tipo de Pagamento salvo com sucesso!');
				}).error(function (erro){
					alert(erro);
				});				
			}
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
		$scope.mensagens = [];
		$http.get(urlcategoria).success(function (categorias) {
			$scope.categorias = categorias;
		}).error(function (erro) {
			alert(erro);
		});
	}
	
	$scope.excluir = function() {
		$scope.mensagens = [];
		if ($scope.categoria.idCategoria == ''){
			alert('Selecione uma Categoria');
		} else {
			$http.delete(urlcategoria+"/"+$scope.categoria.idCategoria).success(function() {
				$scope.categorias.splice($scope.categorias.indexOf($scope.categoria), 1);	
				$scope.novo();
				$scope.mensagens.push('Categoria excluído com sucesso');
			}).error(function (erro) {
				$scope.montaMensagemErro(erro.parameterViolations);
			});
		}
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