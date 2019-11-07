<!DOCTYPE HTML>
<html lang="en">
  <head>
    <link href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700" rel="stylesheet" type="text/css" />
    <link href="assets/style.css" rel="stylesheet" type="text/css" />
  </head>
  <body ng-app="appChat">
    <div ng-controller="ControladorChat" class="container">
      <form ng-submit="anadirMensaje()" name="mensajeForm">
        <input type="text" placeholder="Escribe un nuevo mensaje..." ng-model="mensaje" />
        <div class="info">
          <span class="contador" ng-bind="max - mensaje.length" ng-class="{danger: mensaje.length > max}">140</span>
          <button ng-disabled="mensaje.length > max || mensaje.length === 0">Enviar</button>
        </div>
      </form>
      <hr />
      <p ng-repeat="mensaje in mensajes | orderBy:'hora':true" class="mensaje">
        <time>{{mensaje.hora | date:'HH:mm'}}</time>
        <span ng-class="{self: mensaje.self}">{{mensaje.mensaje}}</span>
      </p>
    </div>
    
    <script src="libs/sockjs/sockjs.min.js" type="text/javascript"></script>
    <script src="libs/stomp-websocket/lib/stomp.min.js" type="text/javascript"></script>
    <script src="libs/angular/angular.min.js"></script>
    <script src="libs/lodash/dist/lodash.min.js"></script>
    <script src="app/app.js" type="text/javascript"></script>
    <script src="app/controllers.js" type="text/javascript"></script>
    <script src="app/services.js" type="text/javascript"></script>
  </body>
</html>
