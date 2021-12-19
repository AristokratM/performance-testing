package simulations

import io.gatling.core.Predef.*
import io.gatling.http.Predef.*

import baseConfig.BaseSimulation

class GetEinsteinQuotesConstantUsersPerSecSimualtion extends BaseSimulation{
  def GetEinsteinQuotes() =
    exec(
      http(s"Get Einstein quotes request")
        .get("/search/authors?query=Einstein")
        .check(status.is(200))
    )

  val scn = scenario("Get Einstein quotes scenario")
    .exec(GetEinsteinQuotes())

  setUp(scn.inject(
    constantUsersPerSec(20) during 5)
    .protocols(httpConf))
}
