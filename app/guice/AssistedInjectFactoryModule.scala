package guice

import com.google.inject.Binder
import com.google.inject.assistedinject.FactoryModuleBuilder
import net.codingwell
import net.codingwell.scalaguice.{InternalModule, typeLiteral}

trait AssistedInjectFactoryModule[B <: Binder] extends codingwell.scalaguice.ScalaPrivateModule {
  self: InternalModule[B] =>

  /**
    * Bind a component that has assisted dependencies to a factory of type [[ApiFactory]]
    * that will be used to create that component once the assisted dependency is provided.
    * @tparam C The component type
    */
  protected[this] def bindToFactory[C: Manifest]: Unit = {
    bindToFactory[C, C, ApiFactory[C]]
  }

  /**
    * Bind a component that has assisted dependencies to a factory of type [[guice.GuiceFactory]]
    * that will be used to create that component once the assisted dependency is provided.
    * Use this method is your service has implementations and you want to code to the interface,
    * or
    * if you want to specify a different type of factory.
    * @tparam I The component interface type
    * @tparam C The component concrete type
    * @tparam F The factory type
    */
  protected[this] def bindToFactory[I: Manifest, C <: I: Manifest, F: Manifest]: Unit = {
    expose[F]
    binderAccess
      .install(new FactoryModuleBuilder()
        .implement(typeLiteral[I], typeLiteral[C])
        .build(typeLiteral[F]))
  }
}
