// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset

// @LINE:10
package infraestructura.controlador.javascript {

  // @LINE:10
  class ReversecontroladorPersona(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:10
    def crear: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "infraestructura.controlador.controladorPersona.crear",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "personas"})
        }
      """
    )
  
    // @LINE:11
    def actualizar: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "infraestructura.controlador.controladorPersona.actualizar",
      """
        function() {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "personas"})
        }
      """
    )
  
    // @LINE:14
    def obtenerPorInicialNombre: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "infraestructura.controlador.controladorPersona.obtenerPorInicialNombre",
      """
        function(inicialNombre0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "personas/nombre/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("inicialNombre", inicialNombre0))})
        }
      """
    )
  
    // @LINE:12
    def eliminar: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "infraestructura.controlador.controladorPersona.eliminar",
      """
        function(id0) {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "personas/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Int]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:13
    def obtenerPorId: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "infraestructura.controlador.controladorPersona.obtenerPorId",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "personas/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Int]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
  }


}
