var app = angular.module('clienteModule',[]);

app.controller('clienteControl',function($scope,$http){
	
	var url = 'http://localhost:8080/SistemaEcommerce/rs/cliente';
	
	//$scope.clientes = [{'codigo':1,'nome':'Cliente 1','cargo':'professor','endereco':'rua aqui','cidade':'Udia',
	//					'cep':'38400420','pais':'Brasil','telefone':'12345678','fax':'23456'},
	//				  {'codigo':2,'nome':'Cliente 2','cargo':'analista mp3','endereco':'rua la','cidade':'Udia',
	//					'cep':'38400421','pais':'Brasil','telefone':'87654321','fax':'12345'}
	//				  ];
					  
	$scope.novo = function() {
		$scope.cliente = {};
	}
	
	$scope.salvar = function() {
		$http.post(url,$scope.cliente).success(function (clientesRetorno) {
			$scope.clientes.push(clientesRetorno);
		}).error(function (mensagemErro) {
			alert(mensagemErro);
		});
		$scope.clientes.push($scope.cliente);
		$scope.novo();
	}
	
	$scope.excluir = function() {
		var urlDelete = 'http://localhost:8080/SistemaEcommerce/rs/cliente/' + $scope.cliente.codigo;
		$http.delete(urlDelete).success(function () {
			$scope.novo();
		}).error(function (mensagemErro) {
			alert(mensagemErro);
		});
		$scope.clientes.splice($scope.clientes.indexOf($scope.cliente),1);
		$scope.novo();
	}
	
	$scope.pesquisar = function() {
		$http.get(url).success(function (clientesRetorno) {
			$scope.clientes = clientesRetorno;
		}).error(function (mensagemErro) {
			alert(mensagemErro);
		});
	}
	
	$scope.pesquisar();
	
	$scope.seleciona = function(clienteTabela) {
		$scope.cliente = clienteTabela;
	}
	
});