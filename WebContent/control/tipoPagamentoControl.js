var app = angular.module('tipoPagamentoModule',[]);
app.controller('tipoPagamentoControl',function($scope,$http){
	
	url = 'http://localhost:8080/DS2016-2Ecommerce/rs/tipoPagamento';
	
	$scope.salvar = function() {	
		if ($scope.tipoPagamento.idAluno == undefined || $scope.tipoPagamento.idAluno == '') {    		
			$http.post(url,$scope.tipoPagamento).success(function(tipoPagamentosRetorno) {
				$scope.tipoPagamentos.push(tipoPagamentosRetorno);
				$scope.novo();
				$scope.mensagens.push('Tipo de Pagamento salvo com sucesso!');
			}).error(function (erro) {
				$scope.montaMensagemErro(erro.parameterViolations);
			});
		} else {
			$http.put(url,$scope.tipoPagamento).success(function(tipoPagamento) {
				$scope.pesquisar();
				$scope.novo();
				$scope.mensagens.push('Tipo de Pagamento atualizado com sucesso!');
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
		$http.get(url).success(function (tipoPagamentos) {
			$scope.tipoPagamentos = tipoPagamentos;
		}).error(function (erro) {
			alert(erro);
		});
	}
	
	$scope.excluir = function() {
		if ($scope.tipoPagamento.idAluno == undefined || $scope.tipoPagamento.idAluno == '') {
			$scope.mensagens.push('Selecione um Tipo de Pagamento');
		} else {
			$http.delete(url+"/"+$scope.tipoPagamento.idAluno).success(function() {
				$scope.tipoPagamentos.splice($scope.tipoPagamentos.indexOf($scope.tipoPagamento), 1);	
				$scope.novo();
				$scope.mensagens.push('Tipo de Pagamento excluído com sucesso!');
			}).error(function (erro) {
				$scope.montaMensagemErro(erro.parameterViolations);
			});
		}
	}
	
	$scope.novo = function() {
		$scope.tipoPagamento = {};
		$scope.mensagens=[];
	}
	
	$scope.seleciona = function(tipoPagamento) {
		$scope.tipoPagamento = tipoPagamento;
	}
	
	$scope.pesquisar();
	$scope.novo();
	
});