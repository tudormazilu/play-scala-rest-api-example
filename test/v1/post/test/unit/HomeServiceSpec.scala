package v1.post.test.unit

import guice.ApiContext
import org.scalatest.{MustMatchers, OptionValues, WordSpec}
import play.api.i18n.MessagesApi
import services.HomeService
import v1.post.test.guice.MyApplicationFactory

class HomeServiceSpec extends WordSpec with MyApplicationFactory with MustMatchers with OptionValues {

  val app = fakeApplication()
  private val service = new HomeService(ApiContext(4), app.injector.instanceOf(classOf[MessagesApi]))

  "doStuff" should {
    "return ok" in {
      service.doStuff() mustEqual "stuff done"
    }
  }

}
