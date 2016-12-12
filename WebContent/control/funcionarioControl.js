var app = angular.module('funcionarioModule',['angularUtils.directives.dirPagination']);
app.controller('funcionarioControl',function($scope,$http){
	
	url = 'http://localhost:8080/DS2016-2Ecommerce/rs/funcionario';
	
	$scope.salvar = function() {	
		if ($scope.funcionario.idFuncionario == undefined || $scope.funcionario.idFuncionario == '') {    		
			$http.post(url,$scope.funcionario).success(function(funcionariosRetorno) {				
				$scope.funcionarios.push(funcionariosRetorno);
				$scope.novo();
				$scope.mensagens.push('Funcionario salvo com sucesso');
			}).error(function (erro) {
				//$scope.mensagens.push('Erro ao salvar Funcionario: '+JSON.stringify(erro));
				$scope.montaMensagemErro(erro.parameterViolations);
			});
		} else {
			$http.put(url,$scope.funcionario).success(function(funcionario) {
				$scope.pesquisar();
				$scope.novo();
				$scope.mensagens.push('Funcionario atualizado com sucesso');
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
		$http.get(url).success(function (funcionarios) {
			$scope.funcionarios = funcionarios;
		}).error(function (erro) {
			alert(erro);
		});
	}
	
	$scope.excluir = function() {
		if ($scope.funcionario.idFuncionario == undefined || $scope.funcionario.idFuncionario == '') {
			$scope.mensagens.push('Selecione um Funcionario');
		} else {
			$http.delete(url+"/"+$scope.funcionario.idFuncionario).success(function() {
				$scope.funcionarios.splice($scope.funcionarios.indexOf($scope.funcionario), 1);	
				$scope.novo();
				$scope.mensagens.push('Funcionario excluído com sucesso');
			}).error(function (erro) {
				//$scope.mensagens.push('Erro ao salvar Aluno: '+JSON.stringify(erro));
				$scope.montaMensagemErro(erro.parameterViolations);
			});
		}
	}
	
	$scope.novo = function() {
		$scope.funcionario = {};
		$scope.mensagens=[];
	}
	
	$scope.seleciona = function(funcionario) {
		$scope.funcionario = funcionario;
	}
	
	$scope.pesquisar();
	$scope.novo();
	
});