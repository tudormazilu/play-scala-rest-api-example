package guice

import play.api.ApplicationLoader
import play.api.inject.guice.{GuiceApplicationBuilder, GuiceApplicationLoader}

class MyApplicationLoader extends GuiceApplicationLoader {
  override protected def builder(context: ApplicationLoader.Context): GuiceApplicationBuilder = {
    initialBuilder
      .in(context.environment)
      .loadConfig(context.initialConfiguration)
      .overrides(overrides(context): _*)
      .bindings(new Module())
  }
}
