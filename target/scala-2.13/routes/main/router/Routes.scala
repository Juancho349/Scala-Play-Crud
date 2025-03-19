// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:7
  AsyncController_0: controllers.AsyncController,
  // @LINE:8
  CountController_1: controllers.CountController,
  // @LINE:10
  controladorPersona_2: infraestructura.controlador.controladorPersona,
  // @LINE:17
  Assets_3: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

  @javax.inject.Inject()
  def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:7
    AsyncController_0: controllers.AsyncController,
    // @LINE:8
    CountController_1: controllers.CountController,
    // @LINE:10
    controladorPersona_2: infraestructura.controlador.controladorPersona,
    // @LINE:17
    Assets_3: controllers.Assets
  ) = this(errorHandler, AsyncController_0, CountController_1, controladorPersona_2, Assets_3, "/")

  def withPrefix(addPrefix: String): Routes = {
    val prefix = play.api.routing.Router.concatPrefix(addPrefix, this.prefix)
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, AsyncController_0, CountController_1, controladorPersona_2, Assets_3, prefix)
  }

  private val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """async""", """controllers.AsyncController.message"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """count""", """controllers.CountController.count"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """personas""", """infraestructura.controlador.controladorPersona.crear()"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """personas""", """infraestructura.controlador.controladorPersona.actualizar()"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """personas/""" + "$" + """id<[^/]+>""", """infraestructura.controlador.controladorPersona.eliminar(id:Int)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """personas/""" + "$" + """id<[^/]+>""", """infraestructura.controlador.controladorPersona.obtenerPorId(id:Int)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """personas/nombre/""" + "$" + """inicialNombre<[^/]+>""", """infraestructura.controlador.controladorPersona.obtenerPorInicialNombre(inicialNombre:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(file:String)"""),
    Nil
  ).foldLeft(Seq.empty[(String, String, String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String, String, String)]
    case l => s ++ l.asInstanceOf[List[(String, String, String)]]
  }}


  // @LINE:7
  private lazy val controllers_AsyncController_message0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("async")))
  )
  private lazy val controllers_AsyncController_message0_invoker = createInvoker(
    AsyncController_0.message,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AsyncController",
      "message",
      Nil,
      "GET",
      this.prefix + """async""",
      """""",
      Seq()
    )
  )

  // @LINE:8
  private lazy val controllers_CountController_count1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("count")))
  )
  private lazy val controllers_CountController_count1_invoker = createInvoker(
    CountController_1.count,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CountController",
      "count",
      Nil,
      "GET",
      this.prefix + """count""",
      """""",
      Seq()
    )
  )

  // @LINE:10
  private lazy val infraestructura_controlador_controladorPersona_crear2_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("personas")))
  )
  private lazy val infraestructura_controlador_controladorPersona_crear2_invoker = createInvoker(
    controladorPersona_2.crear(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "infraestructura.controlador.controladorPersona",
      "crear",
      Nil,
      "POST",
      this.prefix + """personas""",
      """ RUTAS""",
      Seq()
    )
  )

  // @LINE:11
  private lazy val infraestructura_controlador_controladorPersona_actualizar3_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("personas")))
  )
  private lazy val infraestructura_controlador_controladorPersona_actualizar3_invoker = createInvoker(
    controladorPersona_2.actualizar(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "infraestructura.controlador.controladorPersona",
      "actualizar",
      Nil,
      "PUT",
      this.prefix + """personas""",
      """""",
      Seq()
    )
  )

  // @LINE:12
  private lazy val infraestructura_controlador_controladorPersona_eliminar4_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("personas/"), DynamicPart("id", """[^/]+""", encodeable=true)))
  )
  private lazy val infraestructura_controlador_controladorPersona_eliminar4_invoker = createInvoker(
    controladorPersona_2.eliminar(fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "infraestructura.controlador.controladorPersona",
      "eliminar",
      Seq(classOf[Int]),
      "DELETE",
      this.prefix + """personas/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:13
  private lazy val infraestructura_controlador_controladorPersona_obtenerPorId5_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("personas/"), DynamicPart("id", """[^/]+""", encodeable=true)))
  )
  private lazy val infraestructura_controlador_controladorPersona_obtenerPorId5_invoker = createInvoker(
    controladorPersona_2.obtenerPorId(fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "infraestructura.controlador.controladorPersona",
      "obtenerPorId",
      Seq(classOf[Int]),
      "GET",
      this.prefix + """personas/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:14
  private lazy val infraestructura_controlador_controladorPersona_obtenerPorInicialNombre6_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("personas/nombre/"), DynamicPart("inicialNombre", """[^/]+""", encodeable=true)))
  )
  private lazy val infraestructura_controlador_controladorPersona_obtenerPorInicialNombre6_invoker = createInvoker(
    controladorPersona_2.obtenerPorInicialNombre(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "infraestructura.controlador.controladorPersona",
      "obtenerPorInicialNombre",
      Seq(classOf[String]),
      "GET",
      this.prefix + """personas/nombre/""" + "$" + """inicialNombre<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:17
  private lazy val controllers_Assets_versioned7_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""", encodeable=false)))
  )
  private lazy val controllers_Assets_versioned7_invoker = createInvoker(
    Assets_3.versioned(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String]),
      "GET",
      this.prefix + """assets/""" + "$" + """file<.+>""",
      """ Map static resources from the /public folder to the /assets URL path""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:7
    case controllers_AsyncController_message0_route(params@_) =>
      call { 
        controllers_AsyncController_message0_invoker.call(AsyncController_0.message)
      }
  
    // @LINE:8
    case controllers_CountController_count1_route(params@_) =>
      call { 
        controllers_CountController_count1_invoker.call(CountController_1.count)
      }
  
    // @LINE:10
    case infraestructura_controlador_controladorPersona_crear2_route(params@_) =>
      call { 
        infraestructura_controlador_controladorPersona_crear2_invoker.call(controladorPersona_2.crear())
      }
  
    // @LINE:11
    case infraestructura_controlador_controladorPersona_actualizar3_route(params@_) =>
      call { 
        infraestructura_controlador_controladorPersona_actualizar3_invoker.call(controladorPersona_2.actualizar())
      }
  
    // @LINE:12
    case infraestructura_controlador_controladorPersona_eliminar4_route(params@_) =>
      call(params.fromPath[Int]("id", None)) { (id) =>
        infraestructura_controlador_controladorPersona_eliminar4_invoker.call(controladorPersona_2.eliminar(id))
      }
  
    // @LINE:13
    case infraestructura_controlador_controladorPersona_obtenerPorId5_route(params@_) =>
      call(params.fromPath[Int]("id", None)) { (id) =>
        infraestructura_controlador_controladorPersona_obtenerPorId5_invoker.call(controladorPersona_2.obtenerPorId(id))
      }
  
    // @LINE:14
    case infraestructura_controlador_controladorPersona_obtenerPorInicialNombre6_route(params@_) =>
      call(params.fromPath[String]("inicialNombre", None)) { (inicialNombre) =>
        infraestructura_controlador_controladorPersona_obtenerPorInicialNombre6_invoker.call(controladorPersona_2.obtenerPorInicialNombre(inicialNombre))
      }
  
    // @LINE:17
    case controllers_Assets_versioned7_route(params@_) =>
      call(params.fromPath[String]("file", None)) { (file) =>
        controllers_Assets_versioned7_invoker.call(Assets_3.versioned(file))
      }
  }
}
