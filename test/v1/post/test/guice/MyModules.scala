package v1.post.test.guice

import com.google.inject.{Guice, PrivateBinder}
import guice.AssistedInjectFactoryModule
import play.api.i18n.{DefaultLangs, DefaultMessagesApi, MessagesApi}
import play.api.{Configuration, Environment}
import services.HomeService

object MyModules {
  val injector = Guice.createInjector(MyModule)

  object MyModule extends AssistedInjectFactoryModule[PrivateBinder] {
    override def configure(): Unit = {

      val conf = Configuration.reference
      val messagesApi = new DefaultMessagesApi(Environment.simple(), conf, new DefaultLangs(conf))

      bind[MessagesApi].toInstance(messagesApi)
      bindToFactory[HomeService]
    }
  }

}
