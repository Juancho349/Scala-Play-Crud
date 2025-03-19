package dominio.servicio

import com.google.inject.Inject
import dominio.modelo.Persona
import dominio.puerto.PersonaRepositorio

import scala.concurrent.Future

class ServicioCrear @Inject()(personaRepositorio: PersonaRepositorio) {

  def crearPersona (persona: Persona): Future[Persona] = {
    personaRepositorio.crear(persona)
  }




}
