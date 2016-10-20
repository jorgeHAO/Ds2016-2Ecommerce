var app = angular.module('alunoModule',[]);

app.controller('alunoControl',function($scope,$http){
	
	var url = 'http://localhost:8080/DS2016-2Ecommerce/rs/aluno';
	
	//$scope.clientes = [{'codigo':1,'nome':'Cliente 1','cargo':'professor','endereco':'rua aqui','cidade':'Udia',
	//					'cep':'38400420','pais':'Brasil','telefone':'12345678','fax':'23456'},
	//				  {'codigo':2,'nome':'Cliente 2','cargo':'analista mp3','endereco':'rua la','cidade':'Udia',
	//					'cep':'38400421','pais':'Brasil','telefone':'87654321','fax':'12345'}
	//				  ];
					  
	$scope.novo = function() {
		$scope.aluno = {};
	}
	
	$scope.salvar = function() {
		$http.post(url,$scope.aluno).success(function (alunosRetorno) {
			$scope.alunos.push(alunosRetorno);
		}).error(function (mensagemErro) {
			alert(mensagemErro);
		});
		$scope.alunos.push($scope.aluno);
		$scope.novo();
	}
	
	$scope.excluir = function() {
		var urlDelete = 'http://127.0.0.1:8080/DS2016-2Ecommerce/rs/aluno/' + $scope.aluno.codigo;
		$http.delete(urlDelete).success(function () {
			$scope.novo();
		}).error(function (mensagemErro) {
			alert(mensagemErro);
		});
		$scope.alunos.splice($scope.alunos.indexOf($scope.aluno),1);
		$scope.novo();
	}
	
	$scope.pesquisar = function() {
		$http.get(url).success(function (alunosRetorno) {
			$scope.alunos = alunosRetorno;
		}).error(function (mensagemErro) {
			alert(mensagemErro);
		});
	}
	
	$scope.pesquisar();
	
	$scope.seleciona = function(alunoTabela) {
		$scope.aluno = alunoTabela;
	}
	
});