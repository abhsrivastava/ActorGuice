package com.abhi

import javax.inject.{Named, Singleton}

import akka.actor.{ActorSystem, Props}
import com.abhi.actor.MyActor
import com.abhi.logic.Logic
import com.google.inject.{AbstractModule, Provides}
import net.codingwell.scalaguice.ScalaModule

/**
  * Created by ASrivastava on 11/3/17.
  */
class MyModule extends AbstractModule with ScalaModule{
   def configure() : Unit = {
      bind[ActorSystem].toInstance(ActorSystem())
      bind[Logic]
   }

   @Provides
   @Singleton
   @Named("MyActor")
   def getMyActor(actorSystem: ActorSystem, logic: Logic) = {
      actorSystem.actorOf(Props(new MyActor(logic)))
   }
}
