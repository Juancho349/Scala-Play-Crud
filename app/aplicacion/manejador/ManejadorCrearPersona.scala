package aplicacion.manejador

import aplicacion.comando.ComandoCrearPersona
import com.google.inject.Inject
import dominio.modelo.Persona
import dominio.servicio.ServicioCrear
import org.apache.pekko.actor.ActorSystem
import play.api.Configuration

import scala.concurrent.{ExecutionContext, Future}

class ManejadorCrearPersona @Inject() (servicioCrear: ServicioCrear, configuration: Configuration, actorSystem: ActorSystem)(implicit executionContext: ExecutionContext) {

  def manejadorCrearPersona (comandoCrearPersona: ComandoCrearPersona): Future[Persona]= {
    val persona = Persona(comandoCrearPersona.id, comandoCrearPersona.nombre, comandoCrearPersona.edad)
    servicioCrear.crearPersona(persona)
  }

}
