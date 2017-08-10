package v1.post.test.guice

import org.scalatestplus.play.FakeApplicationFactory
import play.api._
import play.api.inject.guice.{GuiceApplicationBuilder, GuiceApplicationLoader}
import play.core.DefaultWebCommands

trait MyApplicationFactory extends FakeApplicationFactory {

  /**
   * An application builder for running an application in tests
   */
  class MyApplicationBuilder {

    def build(): Application = {
      val env = Environment.simple()
      val context = ApplicationLoader.Context(
        environment = env,
        sourceMapper = None,
        webCommands = new DefaultWebCommands(),
        initialConfiguration = Configuration.load(env)
      )
      val loader = new MyApplicationLoaderMock()
      loader.load(context)
    }
  }

  class MyApplicationLoaderMock extends GuiceApplicationLoader {
    override protected def builder(context: ApplicationLoader.Context): GuiceApplicationBuilder = {
      initialBuilder
        .in(context.environment)
        .loadConfig(context.initialConfiguration)
        .overrides(overrides(context): _*)
        .bindings(MyModules.MyModule)
    }
  }

  override def fakeApplication(): Application = {
    new MyApplicationBuilder().build()
  }
}
