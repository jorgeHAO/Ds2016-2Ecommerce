var app = angular.module('simuladoModule',[]);
app.controller('simuladoControl',function($scope,$http){
	
	url = 'http://localhost:8080/DS2016-2Ecommerce/rs/simulado';
	urlCategoria = 'http://localhost:8080/DS2016-2Ecommerce/rs/categoria';
	
	$scope.salvar = function() {	
		if ($scope.simulado.idSimulado == undefined || $scope.simulado.idSimulado == '') {    		
			$http.post(url,$scope.simulado).success(function(simuladosRetorno) {				
				$scope.simulados.push(simuladosRetorno);
				$scope.novo();
				$scope.mensagens.push('Simulado salvo com sucesso');
			}).error(function (erro) {
				//$scope.mensagens.push('Erro ao salvar Simulado: '+JSON.stringify(erro));
				$scope.montaMensagemErro(erro.parameterViolations);
			});
		} else {
			$http.put(url,$scope.simulado).success(function(simulado) {
				$scope.pesquisar();
				$scope.novo();
				$scope.mensagens.push('Simulado atualizado com sucesso');
			}).error(function (erro) {				
				$scope.montaMensagemErro(erro.parameterViolations);
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
		$http.get(url).success(function (simulados) {
			$scope.simulados = simulados;
		}).error(function (erro) {
			alert(erro);
		});
		
		// Buscando categorias para montar a combo de categorias
		$http.get(urlCategoria).success(function (categorias) {
			$scope.categorias = categorias;
		}).error(function (erro) {
			alert(erro);
		});
		
	}
	
	$scope.excluir = function() {
		if ($scope.simulado.idSimulado == undefined || $scope.simulado.idSimulado == '') {
			$scope.mensagens.push('Selecione um Simulado');
		} else {
			$http.delete(url+"/"+$scope.simulado.idSimulado).success(function() {
				$scope.simulados.splice($scope.simulados.indexOf($scope.simulado), 1);	
				$scope.novo();
				$scope.mensagens.push('Simulado excluído com sucesso');
			}).error(function (erro) {
				//$scope.mensagens.push('Erro ao salvar Simulado: '+JSON.stringify(erro));
				$scope.montaMensagemErro(erro.parameterViolations);
			});
		}
	}
	
	$scope.novo = function() {
		$scope.simulado = {};
		$scope.mensagens=[];
	}
	
	$scope.seleciona = function(simulado) {
		$scope.simulado = simulado;
	}
	
	$scope.pesquisar();
	$scope.novo();
	
});