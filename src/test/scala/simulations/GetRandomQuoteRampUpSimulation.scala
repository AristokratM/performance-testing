package simulations

import io.gatling.core.Predef.*
import io.gatling.http.Predef.*

import baseConfig.BaseSimulation

class GetRandomQuoteRampUpSimulation extends BaseSimulation {
  def getRandomQuote() =
    exec(http("Get random quote request}")
      .get("/random")
      .check(status.is(200)))

  val scn = scenario("Get random quote scenario")
    .exec(getRandomQuote())

  setUp(scn.inject(
    rampUsers(50) during 5)
    .protocols(httpConf))
}
