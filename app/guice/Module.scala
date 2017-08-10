package guice

import com.google.inject.PrivateBinder
import services.HomeService

/**
  * Sets up custom components for Play.
  *
  * https://www.playframework.com/documentation/2.5.x/ScalaDependencyInjection
  */
class Module extends AssistedInjectFactoryModule[PrivateBinder] {

  override def configure() = {
    bindToFactory[HomeService]
  }
}
