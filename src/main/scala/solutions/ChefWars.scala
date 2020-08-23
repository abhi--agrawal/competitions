package competitions.solutions

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

/**
  * https://www.codechef.com/AUG20B/problems/CHEFWARS
  *
  * On the ice planet Hoth, Chef has run into his arch-nemesis, DarthForces. Darth has a peculiar fighting style ― he does not attack,
  * but simply defends and lets his opponent tire himself out.
  *
  * Chef has a lightsaber which has an attack power denoted by P. He keeps hitting Darth with the lightsaber. Every time he hits,
  * Darth's health decreases by the current attack power of the lightsaber (by P points), and afterwards, P decreases to ⌊P2⌋.
  *
  * If the attack power becomes 0 before Darth's health becomes 0 or less, Chef dies. Otherwise, Darth dies.
  * You are given Darth's initial health H and the initial attack power P. Tell Chef if he can beat Darth or if he should escape.
  */
object ChefWars {

  def main(args : Array[String]) = {
    val in = scala.io.StdIn
    val testCases : Int = in.readLine().toInt
    var solutionList : mutable.ListBuffer[Int] = ListBuffer.empty
    for (_ <- 0 until testCases) {
      val nums = in.readLine().split(" ").toList.map(_ toInt)
      solutionList += attack(nums(0), nums(1))
    }

    solutionList.foreach(cur => {
      println(cur)
    })
  }

  def attack(sith: Int, jedi: Int): Int = {

    var Jedi = jedi
    var Sith = sith

    while(Jedi > 0 && Sith > 0) {
      Sith = Sith - Jedi
      Jedi = Jedi >> 1
    }

    if(Sith <= 0) 1 else 0
  }
}
