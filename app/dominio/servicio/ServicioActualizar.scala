package dominio.servicio

import com.google.inject.Inject
import dominio.modelo.Persona
import dominio.puerto.PersonaRepositorio

import scala.concurrent.Future

class ServicioActualizar @Inject() (personaRepositorio: PersonaRepositorio) {

  def actualizar (persona: Persona): Future[Persona]={
    personaRepositorio.actualizar(persona)
  }



}
