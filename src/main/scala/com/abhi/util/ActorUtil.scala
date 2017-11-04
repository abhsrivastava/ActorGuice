package com.abhi.util

import akka.actor.ActorRef
import com.abhi.MyClient.injector
import com.google.inject.name.Names
import com.google.inject.{Injector, Key}

/**
  * Created by ASrivastava on 11/3/17.
  */
object ActorUtil {
   implicit class ActorInjector(injector: Injector) {
      def getActor(name: String) : ActorRef = {
         injector.getInstance(Key.get(classOf[ActorRef], Names.named(name)))
      }
   }
}
