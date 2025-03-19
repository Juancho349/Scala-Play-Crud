// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

import play.api.mvc.Call


import _root_.controllers.Assets.Asset

// @LINE:10
package infraestructura.controlador {

  // @LINE:10
  class ReversecontroladorPersona(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:10
    def crear(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "personas")
    }
  
    // @LINE:11
    def actualizar(): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "personas")
    }
  
    // @LINE:14
    def obtenerPorInicialNombre(inicialNombre:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "personas/nombre/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("inicialNombre", inicialNombre)))
    }
  
    // @LINE:12
    def eliminar(id:Int): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "personas/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("id", id)))
    }
  
    // @LINE:13
    def obtenerPorId(id:Int): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "personas/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("id", id)))
    }
  
  }


}
