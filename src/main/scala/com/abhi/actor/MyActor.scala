package com.abhi.actor

/**
  * Created by ASrivastava on 11/3/17.
  */

import akka.actor.Actor
import com.abhi.logic.Logic

class MyActor (logic: Logic) extends Actor {
   def receive = {
      case msg: MyMsg => sender() ! logic.add(msg.i, msg.j)
   }
}

case class MyMsg(i: Int, j: Int)