var app = angular.module('parcelaModule',['angularUtils.directives.dirPagination']);
app.controller('parcelaControl',function($scope,$http){
	
	url = 'http://localhost:8080/DS2016-2Ecommerce/rs/parcela';
	
	$scope.salvar = function() {	
		$scope.mensagens=[];
		if ($scope.parcela.idParcela == undefined || $scope.parcela.idParcela == '') {
			if($scope.formPrincipal.$invalid){
				$scope.mensagens.push('Campo(s) Obrigatório(s) não Informado(s)!');
			}else{
				$http.post(url,$scope.parcela).success(function(parcelasRetorno) {
					$scope.parcelas.push(parcelasRetorno);
					$scope.novo();
					$scope.mensagens.push('Parcela salvo com sucesso!');
				}).error(function (erro) {
					$scope.montaMensagemErro(erro.parameterViolations);
				});
			}	
		} else {
			$http.put(url,$scope.parcela).success(function(parcela) {
				$scope.pesquisar();
				$scope.novo();
				$scope.mensagens.push('Parcela atualizado com sucesso!');
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
		$http.get(url).success(function (parcelas) {
			$scope.parcelas = parcelas;
		}).error(function (erro) {
			alert(erro);
		});
	}
	
	$scope.excluir = function() {
		$scope.mensagens=[];
		if ($scope.parcela.idParcela == undefined || $scope.parcela.idParcela == '') {
			$scope.mensagens.push('Selecione um Parcela antes de clicar no botão Excluir.');
		} else {
			$http.delete(url+"/"+$scope.parcela.idParcela).success(function() {
				$scope.parcelas.splice($scope.parcelas.indexOf($scope.parcela), 1);	
				$scope.novo();
				$scope.mensagens.push('Parcela excluído com sucesso!');
			}).error(function (erro) {
				$scope.montaMensagemErro(erro.parameterViolations);
			});
		}
	}
	
	$scope.novo = function() {
		$scope.parcela = {};
		$scope.mensagens=[];
	}
	
	$scope.seleciona = function(parcela) {
		$scope.mensagens=[];
		$scope.parcela = parcela;
	}
	
	$scope.pesquisar();
	$scope.novo();
	
	$scope.ordenar = function(keyname){
        $scope.sortKey = keyname;
        $scope.reverse = !$scope.reverse;
    };
	
});