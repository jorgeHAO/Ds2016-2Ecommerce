var app = angular.module('aulaModule',['angularUtils.directives.dirPagination', 'ui.mask', 'luk.money']);
app.controller('aulaControl',function($scope,$http, $filter){
	
	url = 'http://localhost:8080/DS2016-2Ecommerce/rs/aula';
	urlSala = 'http://localhost:8080/DS2016-2Ecommerce/rs/sala';
	urlFuncionario = 'http://localhost:8080/DS2016-2Ecommerce/rs/funcionario';
	urlMateria = 'http://localhost:8080/DS2016-2Ecommerce/rs/materia';
	
	$scope.carregarSalas = function() {
		$http.get(urlSala).success(function (salas) {
			$scope.salas = salas;
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
	
	$scope.carregarMateria = function() {
		$http.get(urlMateria).success(function (materias) {
			$scope.materias = materias;
		}).error(function (erro) {
			alert(erro);
		});
	}
	
	function replaceAll(str, needle, replacement) {
		return str.split(needle).join(replacement);
	}
	
	$scope.prepararCampos = function() {		
		if ($scope.aula.dtAula != undefined && $scope.aula.dtAula != '') {
			$scope.aula.dtAula = replaceAll($scope.aula.dtAula.toString(),'/','');
			var ano = $scope.aula.dtAula.substring(4, 8);
			var mes = $scope.aula.dtAula.substring(2, 4);
			var dia = $scope.aula.dtAula.substring(0, 2);
			$scope.aula.dtAula = ano + '-' + mes + '-' + dia;
		}
	}
	
	$scope.salvar = function() {
		$scope.mensagens=[];
		$scope.prepararCampos();
		if ($scope.aula.idAula == undefined || $scope.aula.idAula == '') {
			if($scope.formPrincipal.$invalid){
				$scope.mensagens.push('Campo(s) Obrigatório(s) não Informado(s)!');
			}else{
				$http.post(url,$scope.aula).success(function(aulasRetorno) {
					var dataFormatada = $filter('date')(aulasRetorno.dtAula, 'dd/MM/yyyy', 'UTC');		
					aulasRetorno.dtAula = dataFormatada;
					$scope.aulas.push(aulasRetorno);
					$scope.novo();
					$scope.mensagens.push('Aula salva com sucesso!');
				}).error(function (erro) {
					$scope.montaMensagemErro(erro.parameterViolations);
				});
			}
		} else {
			$http.put(url,$scope.aula).success(function(aula) {
				$scope.pesquisar();
				$scope.novo();
				$scope.mensagens.push('Aula atualizada com sucesso!');
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
		$http.get(url).success(function (aulas) {
			$scope.aulas = aulas;
		}).error(function (erro) {
			alert(erro);
		});
	}
	
	$scope.excluir = function() {
		$scope.mensagens=[];
		if ($scope.aula.idAula == undefined || $scope.aula.idAula == '') {
			$scope.mensagens.push('Selecione uma Aula antes de clicar no botão Excluir.');
		} else {
			$http.delete(url+"/"+$scope.aula.idAula).success(function() {
				$scope.aulas.splice($scope.aulas.indexOf($scope.aula), 1);	
				$scope.novo();
				$scope.mensagens.push('Aula excluída com sucesso!');
			}).error(function (erro) {
				$scope.montaMensagemErro(erro.parameterViolations);
			});
		}
	}
	
	$scope.novo = function() {
		$scope.aula = {};
		$scope.mensagens=[];
	}
	
	$scope.seleciona = function(aula) {
		$scope.mensagens=[];
		var dataFormatada = $filter('date')(aula.dtAula, 'dd/MM/yyyy', 'UTC');		
		aula.dtAula = dataFormatada;
		$scope.aula = aula;
	}
	
	$scope.pesquisar();
	$scope.novo();
	$scope.carregarSalas();
	$scope.carregarFuncionarios();
	$scope.carregarMateria();
	
	$scope.ordenar = function(keyname){
        $scope.sortKey = keyname;
        $scope.reverse = !$scope.reverse;
    };
	
});