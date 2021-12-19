import io.gatling.app.Gatling
import io.gatling.core.config.GatlingPropertiesBuilder
import simulations.*

@main def main =
  // this is where you specify the class you want to run
  val simClass = classOf[GetRandomQuoteRampUpSimulation].getName

  val props = new GatlingPropertiesBuilder
  props.simulationClass(simClass)

  Gatling.fromMap(props.build)






