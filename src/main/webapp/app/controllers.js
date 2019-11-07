(function(angular) {
  angular.module("appChat.controllers").controller("ControladorChat", function($scope, ServicioChat) {
    $scope.mensajes = [];
    $scope.mensaje = "";
    $scope.max = 140;
    
    $scope.anadirMensaje = function() {
    	ServicioChat.send($scope.mensaje);
      $scope.mensaje = "";
    };
    
    ServicioChat.receive().then(null, null, function(mensaje) {
      $scope.mensajes.push(mensaje);
    });
  });
})(angular);