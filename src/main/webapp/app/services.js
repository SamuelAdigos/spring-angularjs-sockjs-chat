(function(angular, SockJS, Stomp, _, undefined) {
  angular.module("appChat.services").service("ServicioChat", function($q, $timeout) {
    
    var servicio = {}, listener = $q.defer(), socket = {
      client: null,
      stomp: null
    }, mensajeIds = [];
    
    servicio.TIMEOUT_RECONEXION = 30000;
    servicio.URL_SOCKET = "/spring-chat-demo/chat";
    servicio.CHAT_ASUNTO = "/asunto/mensaje";
    servicio.CHAT_BROKER = "/app/chat";
    
    servicio.receive = function() {
      return listener.promise;
    };
    
    servicio.send = function(mensaje) {
      var id = Math.floor(Math.random() * 1000000);
      socket.stomp.send(service.CHAT_BROKER, {
        priority: 9
      }, JSON.stringify({
        mensaje: mensaje,
        id: id
      }));
      mensajeIds.push(id);
    };
    
    var reconectar = function() {
      $timeout(function() {
    	  iniciar();
      }, this.TIMEOUT_RECONEXION);
    };
    
    var obtenerMensaje = function(data) {
      var mensaje = JSON.parse(data), out = {};
      out.mensaje = mensaje.mensaje;
      out.hora = new Date(mensaje.hora);
      if (_.contains(mensajeIds, mensaje.id)) {
        out.self = true;
        mensajeIds = _.remove(mensajeIds, mensaje.id);
      }
      return out;
    };
    
    var inicioListener = function() {
      socket.stomp.subscribe(servicio.CHAT_ASUNTO, function(data) {
        listener.notify(obtenerMensaje(data.body));
      });
    };
    
    var iniciar = function() {
      socket.client = new SockJS(servicio.URL_SOCKET);
      socket.stomp = Stomp.over(socket.client);
      socket.stomp.connect({}, inicioListener);
      socket.stomp.onclose = reconectar;
    };
    
    iniciar();
    return servicio;
  });
})(angular, SockJS, Stomp, _);