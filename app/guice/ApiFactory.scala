package guice

case class ApiContext(dbId: Int)

sealed trait GuiceFactory

trait ApiFactory[T] extends GuiceFactory {

  def build(apiContext: ApiContext): T
}
