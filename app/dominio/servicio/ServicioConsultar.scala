package dominio.servicio

import com.google.inject.Inject
import dominio.modelo.Persona
import dominio.puerto.PersonaRepositorio

import scala.concurrent.Future

class ServicioConsultar @Inject() (personaRepositorio: PersonaRepositorio) {
  def obtenerPersonaporId (id: Int): Future[Option[Persona]]= {
    personaRepositorio.obtenerPorId(id)
  }
  def obtenerPersonaPorInicialNombre (nombre: String): Future[Seq[Persona]]={
    personaRepositorio.obtenerPorInicialdelNombre(nombre)
  }

}
