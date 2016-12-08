var app = angular.module('pagamentoModule',['angularUtils.directives.dirPagination', 'ui.mask', 'luk.money']);
app.controller('pagamentoControl',function($scope,$http, $filter){
	
	url = 'http://localhost:8080/DS2016-2Ecommerce/rs/pagamento';
	urlTipoPagamento = 'http://localhost:8080/DS2016-2Ecommerce/rs/tipoPagamento';
	urlFuncionario = 'http://localhost:8080/DS2016-2Ecommerce/rs/funcionario';
	urlCategoriaAluno = 'http://localhost:8080/DS2016-2Ecommerce/rs/categoriaAluno';
	
	$scope.carregarTiposPagamentos = function() {
		$http.get(urlTipoPagamento).success(function (tipoPagamentos) {
			$scope.tipoPagamentos = tipoPagamentos;
		}).error(function (erro) {
			alert(erro);
		});
	}
	
	$scope.carregarFuncionarios = function() {
		$http.get(urlFuncionario).success(function (funcionarios) {
			$scope.funcionarios = funcionarios;
		}).error(function (erro) {
			alert(erro);
		});
	}
	
	$scope.carregarCategoria = function() {
		$http.get(urlCategoriaAluno).success(function (categorias) {
			$scope.categorias = categorias;
		}).error(function (erro) {
			alert(erro);
		});
	}
	
	function replaceAll(str, needle, replacement) {
		return str.split(needle).join(replacement);
	}
	
	$scope.prepararCampos = function() {
		if ($scope.pagamento.vlPagamento != undefined && $scope.pagamento.vlPagamento != '') {
			if($scope.pagamento.vlPagamento.toString().indexOf(',') != -1){
				$scope.pagamento.vlPagamento = $scope.pagamento.vlPagamento.replace('.','');
				$scope.pagamento.vlPagamento = $scope.pagamento.vlPagamento.replace(',','.');
			}
		}
		
		if ($scope.pagamento.dtPagamento != undefined && $scope.pagamento.dtPagamento != '') {
			$scope.pagamento.dtPagamento = replaceAll($scope.pagamento.dtPagamento.toString(),'/','');
			var ano = $scope.pagamento.dtPagamento.substring(4, 8);
			var mes = $scope.pagamento.dtPagamento.substring(2, 4);
			var dia = $scope.pagamento.dtPagamento.substring(0, 2);
			$scope.pagamento.dtPagamento = ano + '-' + mes + '-' + dia;
		}
	}
	
	$scope.salvar = function() {
		$scope.mensagens=[];
		$scope.prepararCampos();
		if ($scope.pagamento.idPagamento == undefined || $scope.pagamento.idPagamento == '') {
			if($scope.formPrincipal.$invalid){
				$scope.mensagens.push('Campo(s) Obrigatório(s) não Informado(s)!');
			}else{
				$http.post(url,$scope.pagamento).success(function(pagamentosRetorno) {
					var dataFormatada = $filter('date')(pagamentosRetorno.dtPagamento, 'dd/MM/yyyy', 'UTC');		
					pagamentosRetorno.dtPagamento = dataFormatada;
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
		var dataFormatada = $filter('date')(pagamento.dtPagamento, 'dd/MM/yyyy', 'UTC');		
		pagamento.dtPagamento = dataFormatada;
		$scope.pagamento = pagamento;
	}
	
	$scope.pesquisar();
	$scope.novo();
	$scope.carregarTiposPagamentos();
	$scope.carregarFuncionarios();
	$scope.carregarCategoria();
	
	$scope.ordenar = function(keyname){
        $scope.sortKey = keyname;
        $scope.reverse = !$scope.reverse;
    };
	
});