package v1.post.test.unit

import guice.ApiContext
import org.scalatest.{MustMatchers, OptionValues, WordSpec}
import play.api.i18n.MessagesApi
import services.HomeService
import v1.post.test.guice.MyModules

class HomeServiceSpec extends WordSpec with MustMatchers with OptionValues {

  private val service = new HomeService(ApiContext(4), MyModules.injector.getInstance(classOf[MessagesApi]))

  "doStuff" should {
    "return ok" in {
      service.doStuff() mustEqual "stuff done"
    }
  }

}
