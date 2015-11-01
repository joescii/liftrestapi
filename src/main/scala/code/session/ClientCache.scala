package code.session

/**
 * Created by IDEA on 29/10/15.
 */

import code.model.Client

object ClientCache {
  val clients = (1 to 5).toList.map(
      i => Client(i, "Client " + i, "client_" + i + "@email.com")
    )
}
