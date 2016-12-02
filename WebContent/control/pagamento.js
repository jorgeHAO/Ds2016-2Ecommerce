var app = angular.module('pagamentoModule',['angularUtils.directives.dirPagination']);
app.controller('pagamentoControl',function($scope,$http){
	
	url = 'http://localhost:8080/DS2016-2Ecommerce/rs/pagamento';
	
	$scope.salvar = function() {	
		$scope.mensagens=[];
		if ($scope.pagamento.idPagamento == undefined || $scope.pagamento.idPagamento == '') {
			if($scope.formPrincipal.$invalid){
				$scope.mensagens.push('Campo(s) Obrigatório(s) não Informado(s)!');
			}else{
				$http.post(url,$scope.pagamento).success(function(pagamentosRetorno) {
					$scope.pagamentos.push(pagamentosRetorno);
					$scope.novo();
					$scope.mensagens.push('Pagamento salvo com sucesso!');
				}).error(function (erro) {
					$scope.montaMensagemErro(erro.parameterViolations);
				});
			}	
		} else {
			$http.put(url,$scope.pagamento).success(function(pagamento) {
				$scope.pesquisar();
				$scope.novo();
				$scope.mensagens.push('Pagamento atualizado com sucesso!');
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
		$scope.mensagens=[];
		$http.get(url).success(function (pagamentos) {
			$scope.pagamentos = pagamentos;
		}).error(function (erro) {
			alert(erro);
		});
	}
	
	$scope.excluir = function() {
		$scope.mensagens=[];
		if ($scope.pagamento.idPagamento == undefined || $scope.pagamento.idPagamento == '') {
			$scope.mensagens.push('Selecione um Pagamento antes de clicar no botão Excluir.');
		} else {
			$http.delete(url+"/"+$scope.pagamento.idPagamento).success(function() {
				$scope.pagamentos.splice($scope.pagamentos.indexOf($scope.pagamento), 1);	
				$scope.novo();
				$scope.mensagens.push('Pagamento excluído com sucesso!');
			}).error(function (erro) {
				$scope.montaMensagemErro(erro.parameterViolations);
			});
		}
	}
	
	$scope.novo = function() {
		$scope.pagamento = {};
		$scope.mensagens=[];
	}
	
	$scope.seleciona = function(pagamento) {
		$scope.mensagens=[];
		$scope.pagamento = pagamento;
	}
	
	$scope.pesquisar();
	$scope.novo();
	
	$scope.ordenar = function(keyname){
        $scope.sortKey = keyname;
        $scope.reverse = !$scope.reverse;
    };
	
});