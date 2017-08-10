package v1.post.test.guice

import com.google.inject.{Guice, PrivateBinder}
import guice.AssistedInjectFactoryModule
import play.api.i18n.{DefaultLangs, DefaultMessagesApi, MessagesApi}
import play.api.{Configuration, Environment}
import services.HomeService

object MyModules {

  object MyModule extends AssistedInjectFactoryModule[PrivateBinder] {
    override def configure(): Unit = {
      bindToFactory[HomeService]
    }
  }

}
