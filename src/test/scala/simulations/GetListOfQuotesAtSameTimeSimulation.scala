package simulations

import io.gatling.core.Predef.*
import io.gatling.http.Predef.*

import baseConfig.BaseSimulation

class GetListOfQuotesAtSameTimeSimulation extends BaseSimulation{
  def GetListOfQuotes() =
    exec(http("Get list of quotes request")
      .get("/quotes?limit=150")
      .check(status.is(200)))
    
  val scn = scenario("Get list of quotes request")
    .exec(GetListOfQuotes())
  
  setUp(scn.inject(
    atOnceUsers(10))
    .protocols(httpConf))
}
