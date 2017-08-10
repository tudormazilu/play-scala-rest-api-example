package v1.post.test.unit

import controllers.HomeController
import guice.ApiFactory
import org.scalatest.mockito.MockitoSugar
import org.scalatestplus.play.PlaySpec
import play.api.i18n.MessagesApi
import play.api.mvc.Results
import play.api.test.FakeRequest
import play.api.test.Helpers.{OK, status, _}
import services.HomeService
import v1.post.test.guice.MyApplicationFactory

class HomeControllerSpec extends PlaySpec with MyApplicationFactory with Results with MockitoSugar {

  val app = fakeApplication()

  "index" should {
    "be valid" in {

      val messagesApi = app.injector.instanceOf(classOf[MessagesApi])
      val homeService = app.injector.instanceOf(classOf[ApiFactory[HomeService]])
      val controller = new HomeController(homeService, messagesApi)

      val result = controller.index(3).apply(FakeRequest())
      status(result) must be (OK)
    }
  }

}
