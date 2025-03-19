package dominio.servicio

import com.google.inject.Inject
import dominio.puerto.PersonaRepositorio

import scala.concurrent.Future

class ServicioEliminar @Inject() (personaRepositorio: PersonaRepositorio) {
  def eliminar (id: Int): Future[Boolean] ={
    personaRepositorio.eliminar(id)
  }


}
