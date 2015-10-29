package code.rest

import net.liftweb.http.rest.RestHelper
import net.liftweb.http._
import net.liftweb.json.JsonDSL._
import net.liftweb.util.Helpers._
import code.session.ClientCache

/**
 * Created by IDEA on 29/10/15.
 */
object Clients extends RestHelper {
  serve({
    case Req("api" :: "clients" :: Nil, _, GetRequest) => listClients()
  })

  def listClients(): LiftResponse = JsonResponse("clients" -> ClientCache.clients.map(_.asJson))
}

