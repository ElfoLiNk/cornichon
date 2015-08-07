package com.github.agourlay.cornichon

import com.github.agourlay.cornichon.server.RestAPI
import org.scalatest.{ BeforeAndAfterAll, WordSpec }

import scala.concurrent.Await
import scala.concurrent.duration._

trait ExampleServer extends BeforeAndAfterAll {
  self: WordSpec ⇒

  lazy val port = 8080
  lazy val baseUrl = s"http://localhost:$port"
  val server = Await.result(new RestAPI().start(port), 5 second)

  override def afterAll() = {
    server.unbind()
  }
}
