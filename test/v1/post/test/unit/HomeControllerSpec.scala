package v1.post.test.unit

import controllers.HomeController
import guice.ApiFactory
import org.scalatest.mockito.MockitoSugar
import org.scalatestplus.play.PlaySpec
import play.api.i18n.MessagesApi
import play.api.mvc.Results
import play.api.test.FakeRequest
import play.api.test.Helpers._
import play.api.test.Helpers.{OK, status}
import services.HomeService
import v1.post.test.guice.MyModules

class HomeControllerSpec extends PlaySpec with Results with MockitoSugar {

  "index" should {
    "be valid" in {

      val messagesApi = mock[MessagesApi]
      val homeService = MyModules.injector.getInstance(classOf[ApiFactory[HomeService]])
      val controller = new HomeController(homeService, messagesApi)

      val result = controller.index(3).apply(FakeRequest())
      status(result) must be (OK)
    }
  }

}
