package v1.post.test.functional

import controllers.HomeController
import guice.ApiFactory
import org.scalatestplus.play.PlaySpec
import org.scalatestplus.play.guice.GuiceOneAppPerSuite
import play.api.i18n.MessagesApi
import play.api.test.FakeRequest
import play.api.test.Helpers._
import services.HomeService
import v1.post.test.guice.MyApplicationFactory

class HomeControllerFuncTest extends PlaySpec with GuiceOneAppPerSuite with MyApplicationFactory {

  "The GuiceOneAppPerSuite trait" must {
    "start the Application" in {
      val result = controller.index(2).apply(FakeRequest())
      status(result) must be (OK)
    }
  }

  private def controller = {
    new HomeController(app.injector.instanceOf[ApiFactory[HomeService]], app.injector.instanceOf[MessagesApi])
  }

}
