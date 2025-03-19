package aplicacion.manejador

import com.google.inject.Inject
import dominio.servicio.ServicioEliminar

import scala.concurrent.{ExecutionContext, Future}

class ManejadorEliminarPersona @Inject() (servicioEliminar: ServicioEliminar)(implicit executionContext: ExecutionContext) {

  def manejadorEliminarPersona (id: Int): Future[Boolean]= {
    servicioEliminar.eliminar(id)
  }

}
