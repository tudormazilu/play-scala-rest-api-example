package controllers

import com.google.inject.Inject
import guice.{ApiContext, ApiFactory}
import play.api.i18n.MessagesApi
import play.api.mvc.{Action, Controller}
import services.HomeService

/**
  * A very small controller that renders a home page.
  */
class HomeController @Inject() (homeServiceFactory: ApiFactory[HomeService], messagesApi: MessagesApi) extends Controller {

  def index(dbId: Int) = Action { implicit request =>
    Ok(homeServiceFactory.build(ApiContext(dbId)).doStuff())
  }
}
