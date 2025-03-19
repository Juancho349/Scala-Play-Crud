package infraestructura.controlador

import aplicacion.comando.{ComandoActualizarPersona, ComandoCrearPersona}
import aplicacion.consulta.{ObtenerPersonaPorInicialNombre, ObtenerPersonaporId}
import aplicacion.manejador.{ManejadorActualizarPersona, ManejadorCrearPersona, ManejadorEliminarPersona, ManejadorObtenerPorId, ManejadorObtenerPorInicial}
import com.google.inject.Inject
import dominio.modelo.Persona
import play.api.libs.json._
import play.api.mvc.{AbstractController, Action, AnyContent, ControllerComponents, Request}

import scala.concurrent.{ExecutionContext, Future}

class controladorPersona @Inject () (controllerComponents: ControllerComponents, manejadorCrearPersona: ManejadorCrearPersona,
                                     manejadorActualizarPersona: ManejadorActualizarPersona, manejadorObtenerPorInicial: ManejadorObtenerPorInicial,
                                     manejadorObtenerPorId: ManejadorObtenerPorId, manejadorEliminarPersona: ManejadorEliminarPersona) (implicit executionContext: ExecutionContext)
                                      extends AbstractController(controllerComponents){

///metodos para obtener los objetos Json y convertirlos al formato que el back necesita
  implicit val formatoPersonaFormato: OFormat[Persona] = Json.format[Persona]
  implicit val comandoCrearPersonaFormato: OFormat[ComandoCrearPersona] = Json.format[ComandoCrearPersona]
  implicit val comandoActualizarPersonaFormato: OFormat[ComandoActualizarPersona] = Json.format[ComandoActualizarPersona]

  def crear(): Action[AnyContent] = Action.async{ implicit request : Request[AnyContent] =>
    val respuestaServidorJson = request.body.asJson.get
    respuestaServidorJson.validate[ComandoCrearPersona].fold(
      invalid => {
        val errores = invalid.flatMap{case (path, validationError)=>
          validationError.map(error => path.toString() -> error.message)
        }
        Future.successful(BadRequest(Json.obj("errores"-> errores)))

      },
      comandoCrearPersona => {
        manejadorCrearPersona.manejadorCrearPersona(comandoCrearPersona).map{
          persona => Created(Json.toJson(persona))
        }
      }
    )
  }

  def actualizar(): Action[AnyContent] = Action.async{ implicit request : Request[AnyContent] =>

    val respuestaServidorJson = request.body.asJson.get
    respuestaServidorJson.validate[ComandoActualizarPersona].fold(
      invalid => {
        val errores = invalid.flatMap{case (path, validationErros) =>
          validationErros.map(error => path.toString() -> error.message)
        }
        Future.successful(BadRequest(Json.obj("errores" -> errores)))
      },
      comandoActualizarPersona => {
        manejadorActualizarPersona.manejadorActualizarPersona(comandoActualizarPersona).map{
          persona => Ok(Json.toJson(persona))
        }
      }
    )
  }

  def eliminar(id: Int): Action[AnyContent] = Action.async{implicit request: Request[AnyContent] =>
    manejadorEliminarPersona.manejadorEliminarPersona(id).map {
      case true => NoContent
      case false => NotFound
    }
  }

  def obtenerPorId (id: Int): Action[AnyContent] = Action.async{implicit request: Request[AnyContent]=>
    manejadorObtenerPorId.manejadorObtenerporId(ObtenerPersonaporId(id)).map{
      case Some(persona) => Ok(Json.toJson(persona))
      case None => NotFound
    }
  }

  def obtenerPorInicialNombre (inicialNombre: String): Action[AnyContent] = Action.async{implicit request: Request[AnyContent] =>
    manejadorObtenerPorInicial.manejadorObtenerPorInicial(ObtenerPersonaPorInicialNombre(inicialNombre)).map{
      personas => Ok(Json.toJson(personas))
    }
  }


}
