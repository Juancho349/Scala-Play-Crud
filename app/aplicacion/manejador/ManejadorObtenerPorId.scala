package aplicacion.manejador

import aplicacion.consulta.ObtenerPersonaporId
import com.google.inject.Inject
import dominio.modelo.Persona
import dominio.servicio.ServicioConsultar

import scala.concurrent.{ExecutionContext, Future}

class ManejadorObtenerPorId @Inject()(servicioConsultar: ServicioConsultar)(implicit executionContext: ExecutionContext) {

  def manejadorObtenerporId (consulta: ObtenerPersonaporId): Future[Option[Persona]] ={
    servicioConsultar.obtenerPersonaporId(consulta.id)
  }

}
