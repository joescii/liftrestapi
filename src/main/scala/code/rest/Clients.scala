package code.rest

import code.model.Client
import code.session.ClientCache
import net.liftweb.http.rest.RestHelper
import net.liftweb.http._
import net.liftweb.json.JsonDSL._
import net.liftweb.util.Helpers._

/**
 * Created by IDEA on 29/10/15.
 */
object Clients extends RestHelper {
  var clients = (1 to 10).toList.map(
    i => Client(i, "Client " + i, "client_" + i + "@email.com")
  )

  def init: Unit = {
    LiftRules.statelessDispatch.append(Clients)
  }

  serve(List("clients") prefix {
    case XmlGet(Nil, _) => listClients()
  })

  // This does not work
//  def listClients(): LiftResponse = JsonResponse("clients" -> ClientCache.clients.map(_.asJson))

  // This works
   def listClients(): LiftResponse = JsonResponse("clients" -> clients.map(_.asJson))
}

