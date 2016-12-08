var app = angular.module('parcelaModule',['angularUtils.directives.dirPagination', 'ui.mask', 'luk.money']);
app.controller('parcelaControl',function($scope,$http, $filter){
	
	url = 'http://localhost:8080/DS2016-2Ecommerce/rs/parcela';
	urlPagamento = 'http://localhost:8080/DS2016-2Ecommerce/rs/pagamento';
	
	$scope.carregarPagamento = function() {
		$http.get(urlPagamento).success(function (pagamentos) {
			$scope.pagamentos = pagamentos;
		}).error(function (erro) {
			alert(erro);
		});
	}
	
	function replaceAll(str, needle, replacement) {
		return str.split(needle).join(replacement);
	}
	
	$scope.prepararCampos = function() {
		if ($scope.parcela.vlParcela != undefined && $scope.parcela.vlParcela != '') {
			if($scope.parcela.vlParcela.toString().indexOf(',') != -1){
				$scope.parcela.vlParcela = $scope.parcela.vlParcela.replace('.','');
				$scope.parcela.vlParcela = $scope.parcela.vlParcela.replace(',','.');
			}
		}
		
		if ($scope.parcela.dtPagamento != undefined && $scope.parcela.dtPagamento != '') {
			$scope.parcela.dtPagamento = replaceAll($scope.parcela.dtPagamento.toString(),'/','');
			var ano = $scope.parcela.dtPagamento.substring(4, 8);
			var mes = $scope.parcela.dtPagamento.substring(2, 4);
			var dia = $scope.parcela.dtPagamento.substring(0, 2);
			$scope.parcela.dtPagamento = ano + '-' + mes + '-' + dia;
		}
		
		if ($scope.parcela.dtRecebimento != undefined && $scope.parcela.dtRecebimento != '') {
			$scope.parcela.dtRecebimento = replaceAll($scope.parcela.dtRecebimento.toString(),'/','');
			var ano = $scope.parcela.dtRecebimento.substring(4, 8);
			var mes = $scope.parcela.dtRecebimento.substring(2, 4);
			var dia = $scope.parcela.dtRecebimento.substring(0, 2);
			$scope.parcela.dtRecebimento = ano + '-' + mes + '-' + dia;
		}
	}
	
	$scope.salvar = function() {
		$scope.mensagens=[];
		$scope.prepararCampos();
		if ($scope.parcela.idParcela == undefined || $scope.parcela.idParcela == '') {
			if($scope.formPrincipal.$invalid){
				$scope.mensagens.push('Campo(s) Obrigatório(s) não Informado(s)!');
			}else{
				$http.post(url,$scope.parcela).success(function(parcelasRetorno) {
					var dataFormatada = $filter('date')(parcelasRetorno.dtParcela, 'dd/MM/yyyy', 'UTC');		
					parcelasRetorno.dtParcela = dataFormatada;
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
		parcela.dtPagamento = formataData(parcela.dtPagamento);
		parcela.dtRecebimento = formataData(parcela.dtRecebimento);
		$scope.parcela = parcela;
	}
	
	function formataData(data) {
		return $filter('date')(data, 'dd/MM/yyyy', 'UTC');
	}
	
	$scope.selecionaPagamento = function() {
		$scope.mensagens=[];
		if ($scope.parcela.idPagamento != undefined && $scope.parcela.idPagamento != '') {
			var dataFormatada = $filter('date')($scope.parcela.idPagamento.dtPagamento, 'dd/MM/yyyy', 'UTC');
			$scope.parcela.dtPagamento = dataFormatada;			
		}else{				
			$scope.parcela.dtPagamento = '';			
		}
	}
	
	$scope.pesquisar();
	$scope.novo();
	$scope.carregarPagamento();
	
	$scope.ordenar = function(keyname){
        $scope.sortKey = keyname;
        $scope.reverse = !$scope.reverse;
    };
	
});