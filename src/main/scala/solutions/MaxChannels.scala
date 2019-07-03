package solutions

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

/**
  * Q : You have been given list of pairs of times which indicates start and end of an activity.
  * You need to figure out the max no of activities active at any point of time and for how much time.
  */

case class Result(ch: Int, time: String)
case class TimePair(start : String, end : String)
case class Time(hr : Int, min : Int, sec : Int) {
  override def toString: String = {

    var uMin = min
    var uHr = hr
    var uSec = sec

    while(uSec <  0) {
      uMin -= 1
      uSec += 60
    }

    uSec = if(uSec >= 60){
      uMin += uSec / 60
      uSec%60
    }  else uSec

    while(uMin < 0) {
      uHr -= 1
      uMin += 60
    }

    val uuMin = if(uMin >= 60){
      uHr += uMin / 60
      uMin%60
    } else uMin

    val secS = if(uSec<10) "0"+uSec.toString else uSec.toString
    val hrS = if(uHr<10) "0"+uHr.toString else uHr.toString
    val minS = if(uuMin<10) "0"+uuMin.toString else uuMin.toString
    hrS+":"+minS+":"+secS
  }

}

object MaxChannels {

  def main(args: Array[String]): Unit = {

    val in = scala.io.StdIn
    val testCases : Int = in.readInt()
    var solutionList : mutable.ListBuffer[Result] = ListBuffer.empty
    for (_ <- 0 until testCases) {
      val noOfInputTimes = in.readInt()
      var timesList : mutable.ListBuffer[TimePair] = ListBuffer.empty
      for(i <- 0 until noOfInputTimes){
        val timePairString = in.readLine().split(" ")
        timesList +=(TimePair(timePairString(0), timePairString(1)))
      }
      solutionList += (solve(timesList.toList))
    }

    solutionList.foreach(cur => {
      System.out.println(cur.ch + " " + cur.time)
    })

  }

  def solve(timesList: List[TimePair]) : Result = {
    val timeMap = timesList.foldLeft(Map.empty[String, Int])((acc, cur) => {
      if(cur.start != cur.end)
        acc.updated(cur.start, acc.getOrElse(cur.start, 0) + 1).updated(cur.end, acc.getOrElse(cur.end, 0) - 1)
      else acc
    })

    var currentActivities = 0
    var maxActivities = 0
    val zeroTime = Time(0,0,0)
    var previousStartTime = zeroTime
    var totalTime = zeroTime

    timeMap.keySet.toList.sorted.foreach(current => {
      val activities = timeMap.getOrElse(current, 0)
      if(activities > 0){
        currentActivities+=activities
        if(maxActivities < currentActivities) {
          maxActivities = currentActivities
          previousStartTime = setTime(current)
          totalTime = zeroTime
        } else if(maxActivities == currentActivities)
                 previousStartTime = setTime(current)
      } else if(activities < 0){
        if(currentActivities == maxActivities){
          totalTime = add(totalTime, diff(previousStartTime, setTime(current)))
        }
        currentActivities+=activities
      }
    })
    Result(maxActivities,totalTime.toString)
  }

  def setTime(input: String) : Time = {
    val timeArray = input.split(":")
    Time(Integer.parseInt(timeArray(0)), Integer.parseInt(timeArray(1)), Integer.parseInt(timeArray(2)))
  }

  def diff( t1 : Time, t2: Time) : Time = Time(t2.hr - t1.hr, t2.min - t1.min, t2.sec - t1.sec)

  def add( t1 : Time, t2: Time) : Time = Time(t2.hr + t1.hr, t2.min + t1.min, t2.sec + t1.sec)
}
