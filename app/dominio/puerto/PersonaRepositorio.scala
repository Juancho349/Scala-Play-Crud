package dominio.puerto

import dominio.modelo.Persona

import scala.concurrent.Future

trait PersonaRepositorio {
  def crear(persona: Persona): Future[Persona]
  def actualizar(persona: Persona): Future[Persona]
  def obtenerPorId(id: Int): Future[Option[Persona]]
  def obtenerPorInicialdelNombre (nombre: String): Future[Seq[Persona]]
  def eliminar(id: Int): Future[Boolean]

}
