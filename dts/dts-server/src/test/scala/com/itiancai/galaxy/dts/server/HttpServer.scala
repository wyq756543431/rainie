package com.itiancai.galaxy.dts.server

import com.twitter.finagle.http.service.RoutingService
import com.twitter.finagle.http.{Request, Response}
import com.twitter.finagle.{Http, Service}
import com.twitter.util.{Await, Future}

object HttpServer extends App {

  val service1: Service[Request, Response] = new Service[Request, Response] {
    def apply(req: Request): Future[Response] = {
      val response = Response()
      Thread.sleep(1000)
      response.setContentString("0")
      Future.value(response)
    }
  }

  val service2: Service[Request, Response] = new Service[Request, Response] {
    def apply(req: Request): Future[Response] = {
      val response = Response()
      response.setContentString("true")
      Future.value(response)
    }
  }

  val routingService =
    RoutingService.byPath {
      case "/dts/activity" => service1
      case "/dts/action" => service2
    }

  val server = Http.server.serve(":8080", routingService)
  Await.ready(server) // waits until the server resources are released

}
