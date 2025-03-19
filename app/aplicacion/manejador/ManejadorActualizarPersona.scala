package aplicacion.manejador

import aplicacion.comando.ComandoActualizarPersona
import com.google.inject.Inject
import dominio.modelo.Persona
import dominio.servicio.ServicioActualizar

import scala.concurrent.{ExecutionContext, Future}

class ManejadorActualizarPersona @Inject() (servicioActualizar: ServicioActualizar)(implicit executionContext: ExecutionContext){


  def manejadorActualizarPersona (comandoActualizarPersona: ComandoActualizarPersona): Future[Persona]= {
    val persona = Persona(comandoActualizarPersona.id, comandoActualizarPersona.nombre, comandoActualizarPersona.edad)
    servicioActualizar.actualizar(persona)
  }

}
