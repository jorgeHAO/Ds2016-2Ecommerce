var app = angular.module('alunoModule',['angularUtils.directives.dirPagination']);
app.controller('alunoControl',function($scope,$http, $filter){
	
	url = 'http://localhost:8080/DS2016-2Ecommerce/rs/aluno';
	
	$scope.salvar = function() {	
		if ($scope.aluno.idAluno == undefined || $scope.aluno.idAluno == '') {    		
			$http.post(url,$scope.aluno).success(function(alunosRetorno) {				
				$scope.alunos.push(alunosRetorno);
				$scope.novo();
				$scope.mensagens.push('Aluno salvo com sucesso');
			}).error(function (erro) {
				//$scope.mensagens.push('Erro ao salvar Aluno: '+JSON.stringify(erro));
				$scope.montaMensagemErro(erro.parameterViolations);
			});
		} else {
			$http.put(url,$scope.aluno).success(function(aluno) {
				$scope.pesquisar();
				$scope.novo();
				$scope.mensagens.push('Aluno atualizado com sucesso');
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
		$http.get(url).success(function (alunos) {
			$scope.alunos = alunos;
		}).error(function (erro) {
			alert(erro);
		});
	}
	
	$scope.excluir = function() {
		if ($scope.aluno.idAluno == undefined || $scope.aluno.idAluno == '') {
			$scope.mensagens.push('Selecione um Aluno');
		} else {
			$http.delete(url+"/"+$scope.aluno.idAluno).success(function() {
				$scope.alunos.splice($scope.alunos.indexOf($scope.aluno), 1);	
				$scope.novo();
				$scope.mensagens.push('Aluno excluído com sucesso');
			}).error(function (erro) {
				//$scope.mensagens.push('Erro ao salvar Aluno: '+JSON.stringify(erro));
				$scope.montaMensagemErro(erro.parameterViolations);
			});
		}
	}
	
	function formataData(data) {
		return $filter('date')(data, 'dd/MM/yyyy', 'UTC');
	}
	
	$scope.novo = function() {
		$scope.aluno = {};
		$scope.mensagens=[];
	}
	
	$scope.seleciona = function(aluno) {
		aluno.dtNascimento = formataData(aluno.dtNascimento);
		$scope.aluno = aluno;
	}
	
	$scope.pesquisar();
	$scope.novo();
	
});