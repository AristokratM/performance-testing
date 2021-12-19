package baseConfig

import io.gatling.core.Predef.*
import io.gatling.http.Predef.*

class BaseSimulation extends Simulation {
    val httpConf = http
      .baseUrl("https://api.quotable.io/")
      .header("Accept", "application/json")

    val r = scala.util.Random
    def randomId = r.between(1, 20)

    val IdFeeder = Iterator.continually(Map(
        "id" -> r.between(1, 20),
    ))
}
