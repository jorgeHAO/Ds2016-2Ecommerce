var app = angular.module('materiaModule',['angularUtils.directives.dirPagination']);
app.controller('materiaControl',function($scope,$http){
	
	url = 'http://localhost:8080/DS2016-2Ecommerce/rs/materia';
	
	$scope.salvar = function() {	
		$scope.mensagens=[];
		if ($scope.materia.idMateria == undefined || $scope.materia.idMateria == '') {
			if($scope.formPrincipal.$invalid){
				$scope.mensagens.push('Campo(s) Obrigatório(s) não Informado(s)!');
			}else{
				$http.post(url,$scope.materia).success(function(materiasRetorno) {
					$scope.materias.push(materiasRetorno);
					$scope.novo();
					$scope.mensagens.push('Materia salva com sucesso!');
				}).error(function (erro) {
					$scope.montaMensagemErro(erro.parameterViolations);
				});
			}	
		} else {
			$http.put(url,$scope.materia).success(function(materia) {
				$scope.pesquisar();
				$scope.novo();
				$scope.mensagens.push('Materia atualizada com sucesso!');
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
		$http.get(url).success(function (materias) {
			$scope.materias = materias;
		}).error(function (erro) {
			alert(erro);
		});
	}
	
	$scope.excluir = function() {
		$scope.mensagens=[];
		if ($scope.materia.idMateria == undefined || $scope.materia.idMateria == '') {
			$scope.mensagens.push('Selecione uma Materia antes de clicar no botão Excluir.');
		} else {
			$http.delete(url+"/"+$scope.materia.idMateria).success(function() {
				$scope.materias.splice($scope.materias.indexOf($scope.materia), 1);	
				$scope.novo();
				$scope.mensagens.push('Materia excluída com sucesso!');
			}).error(function (erro) {
				$scope.montaMensagemErro(erro.parameterViolations);
			});
		}
	}
	
	$scope.novo = function() {
		$scope.materia = {};
		$scope.mensagens=[];
	}
	
	$scope.seleciona = function(materia) {
		$scope.mensagens=[];
		$scope.materia = materia;
	}
	
	$scope.pesquisar();
	$scope.novo();
	
	$scope.ordenar = function(keyname){
        $scope.sortKey = keyname;
        $scope.reverse = !$scope.reverse;
    };
	
});