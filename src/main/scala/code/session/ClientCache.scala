package code.session

/**
 * Created by IDEA on 29/10/15.
 */

import code.model.Client

object ClientCache {
  var clients: List[Client] = Nil

  def startClient(): Unit = {
    if (clients.isEmpty) clients = (1 to 10).toList.map(
      i => Client(i, "Client " + i, "client_" + i + "@email.com")
    )
  }
}
