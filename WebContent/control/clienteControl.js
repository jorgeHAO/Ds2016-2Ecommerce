var app = angular.module('clienteModule',[]);
app.controller('clienteControl',function($scope,$http){
	
	url = 'http://localhost:8080/DS2016-2Ecommerce/rs/cliente';
	
	$scope.salvar = function() {	
		if ($scope.cliente.idCliente == undefined || $scope.cliente.idCliente == '') {    		
			$http.post(url,$scope.cliente).success(function(clientesRetorno) {				
				$scope.clientes.push(clientesRetorno);
				$scope.novo();
				$scope.mensagens.push('Cliente salvo com sucesso');
			}).error(function (erro) {
				//$scope.mensagens.push('Erro ao salvar Funcionario: '+JSON.stringify(erro));
				$scope.montaMensagemErro(erro.parameterViolations);
			});
		} else {
			$http.put(url,$scope.cliente).success(function(cliente) {
				$scope.pesquisar();
				$scope.novo();
				$scope.mensagens.push('Cliente atualizado com sucesso');
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
		$http.get(url).success(function (clientes) {
			$scope.clientes = clientes;
		}).error(function (erro) {
			alert(erro);
		});
	}
	
	$scope.excluir = function() {
		if ($scope.cliente.idCliente == undefined || $scope.cliente.idCliente == '') {
			$scope.mensagens.push('Selecione um Cliente');
		} else {
			$http.delete(url+"/"+$scope.funcionario.idCliente).success(function() {
				$scope.clientes.splice($scope.clientes.indexOf($scope.cliente), 1);	
				$scope.novo();
				$scope.mensagens.push('Cliente excluído com sucesso');
			}).error(function (erro) {
				//$scope.mensagens.push('Erro ao salvar Aluno: '+JSON.stringify(erro));
				$scope.montaMensagemErro(erro.parameterViolations);
			});
		}
	}
	
	$scope.novo = function() {
		$scope.cliente = {};
		$scope.mensagens=[];
	}
	
	$scope.seleciona = function(cliente) {
		$scope.cliente = cliente;
	}
	
	$scope.pesquisar();
	$scope.novo();
	
});