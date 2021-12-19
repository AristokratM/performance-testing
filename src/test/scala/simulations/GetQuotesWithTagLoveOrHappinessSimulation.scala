package simulations

import baseConfig.BaseSimulation
import io.gatling.core.Predef.*
import io.gatling.http.Predef.*

class GetQuotesWithTagLoveOrHappinessSimulation extends BaseSimulation {
  def GetQuotesWithTagLoveOrHapiness() =
    exec(
      http(s"Get quotes with tag love or hapiness request")
        .get("/quotes?tags=love|happiness")
        .check(status.is(200))
    )

  val scn = scenario("Get quotes with tag love or hapiness scenario")
    .exec(GetQuotesWithTagLoveOrHapiness())

  setUp(scn.inject(
    stressPeakUsers(100)  during 2)
    .protocols(httpConf))
}
