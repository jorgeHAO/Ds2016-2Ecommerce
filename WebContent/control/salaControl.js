var app = angular.module('salaModule',[]);
app.controller('salaControl',function($scope,$http){
	
	url = 'http://localhost:8080/DS2016-2Ecommerce/rs/sala';
	
	$scope.salvar = function() {	
		if ($scope.aluno.idSala == undefined || $scope.sala.idSala == '') {    		
			$http.post(url,$scope.sala).success(function(salasRetorno) {				
				$scope.salas.push(salasRetorno);
				$scope.novo();
				$scope.mensagens.push('Sala salvo com sucesso');
			}).error(function (erro) {
				//$scope.mensagens.push('Erro ao salvar Sala: '+JSON.stringify(erro));
				$scope.montaMensagemErro(erro.parameterViolations);
			});
		} else {
			$http.put(url,$scope.sala).success(function(sala) {
				$scope.pesquisar();
				$scope.novo();
				$scope.mensagens.push('Sala atualizado com sucesso');
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
		$http.get(url).success(function (salas) {
			$scope.salas = salas;
		}).error(function (erro) {
			alert(erro);
		});
	}
	
	$scope.excluir = function() {
		if ($scope.aluno.idSala == undefined || $scope.sala.idSala == '') {
			$scope.mensagens.push('Selecione um Sala');
		} else {
			$http.delete(url+"/"+$scope.sala.idSala).success(function() {
				$scope.salas.splice($scope.salas.indexOf($scope.sala), 1);	
				$scope.novo();
				$scope.mensagens.push('Sala excluído com sucesso');
			}).error(function (erro) {
				//$scope.mensagens.push('Erro ao salvar Sala: '+JSON.stringify(erro));
				$scope.montaMensagemErro(erro.parameterViolations);
			});
		}
	}
	
	$scope.novo = function() {
		$scope.sala = {};
		$scope.mensagens=[];
	}
	
	$scope.seleciona = function(sala) {
		$scope.sala = sala;
	}
	
	$scope.pesquisar();
	$scope.novo();
	
});