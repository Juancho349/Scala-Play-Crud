package aplicacion.manejador

import aplicacion.consulta.ObtenerPersonaPorInicialNombre
import com.google.inject.Inject
import dominio.modelo.Persona
import dominio.servicio.ServicioConsultar

import scala.concurrent.{ExecutionContext, Future}

class ManejadorObtenerPorInicial @Inject() (servicioConsultar: ServicioConsultar)(implicit executionContext: ExecutionContext) {
  def manejadorObtenerPorInicial (consulta: ObtenerPersonaPorInicialNombre): Future[Seq[Persona]]= {
    servicioConsultar.obtenerPersonaPorInicialNombre(consulta.inicialNombre)
  }

}
