// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

package infraestructura.controlador;

import router.RoutesPrefix;

public class routes {
  
  public static final infraestructura.controlador.ReversecontroladorPersona controladorPersona = new infraestructura.controlador.ReversecontroladorPersona(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final infraestructura.controlador.javascript.ReversecontroladorPersona controladorPersona = new infraestructura.controlador.javascript.ReversecontroladorPersona(RoutesPrefix.byNamePrefix());
  }

}
