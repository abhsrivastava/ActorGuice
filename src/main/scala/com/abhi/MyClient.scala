package com.abhi

import akka.actor.ActorSystem
import akka.util.Timeout
import com.abhi.actor.MyMsg
import com.google.inject.Guice
import com.abhi.util.ActorUtil._
import scala.concurrent._
import scala.concurrent.duration._
import akka.pattern.ask
/**
  * Created by ASrivastava on 11/3/17.
  */
object MyClient extends App {
   implicit val timeout = Timeout(5 seconds)
   val injector = Guice.createInjector(new MyModule)
   val myActor = injector.getActor("MyActor")
   val msg = (myActor ? MyMsg(10, 20)).mapTo[Int]
   println(Await.result(msg, Duration.Inf))
   Await.result(injector.getInstance(classOf[ActorSystem]).terminate, Duration.Inf)
}
