package infraestructura.adapatador

import com.google.inject.Inject
import dominio.modelo.Persona
import dominio.puerto.PersonaRepositorio
import slick.jdbc.JdbcBackend.Database
import slick.jdbc.MySQLProfile.api._

import scala.concurrent.{ExecutionContext, Future}

class RepositorioPersonaMysql @Inject() (implicit executionContext: ExecutionContext) extends PersonaRepositorio{

  val bd = Database.forConfig("slicks.dbs.default.db")

  private class PersonaTabla(tag: Tag) extends Table [Persona](tag, "personas"){
    def id= column[Int]("id", O.PrimaryKey)
    def nombre = column[String]("nombre")
    def edad = column[Int]("edad")
    def * = (id, nombre, edad) <> (Persona.tupled, Persona.unapply)

  }

  private val personas = TableQuery[PersonaTabla]

  //crear tabla si no existe
  def crearTablaSiNoExiste (): Future[Unit] = {
    bd.run(personas.schema.createIfNotExists.map(_ =>()))
  }

  override def crear(persona: Persona): Future[Persona] ={
    bd.run(personas += persona).map(_ => persona)
  }

  override def actualizar(persona: Persona): Future[Persona] ={
    bd.run(personas.filter(_.id === persona.id).update((persona)).map(_ => persona))
  }

  override def obtenerPorId(id: Int): Future[Option[Persona]] = {
    bd.run(personas.filter(_.id === id).result.headOption)
  }

  override def obtenerPorInicialdelNombre(nombreInicial: String): Future[Seq[Persona]] = {
    bd.run(personas.filter(_.nombre like s"$nombreInicial%").result)
  }

  override def eliminar(id: Int): Future[Boolean] = {
    bd.run(personas.filter(_.id === id).delete.map(_>0))
  }




  crearTablaSiNoExiste()
}
