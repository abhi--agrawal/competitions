package solutions

import org.junit.jupiter.api.Assertions._
import org.junit.jupiter.api.Test

class MaxChannelsTest  {

  //Test Case 1
  @Test
  def testCase1 = {
  val case1 =    List(
    TimePair("18:30:00","21:30:00"),
    TimePair("07:00:00","23:00:00"),
    TimePair("14:30:00","22:00:00"),
    TimePair("01:30:00","11:30:00"),
    TimePair("07:30:00","13:00:00"),
    TimePair("22:30:00","23:30:00"),
    TimePair("17:30:00","18:00:00"),
    TimePair("01:00:00","02:30:00"))

    val sol = MaxChannels.solve(case1)
    assertEquals(3, sol.ch)
    assertEquals("07:30:00", sol.time)

  }

//2
  @Test
  def testCase2 = {
    val case2 =    List(
      TimePair("01:00:00","02:00:00"),
      TimePair("03:00:00","04:00:00"),
      TimePair("04:00:00","12:00:00"),
      TimePair("15:00:00","24:00:00"))

    val sol = MaxChannels.solve(case2)
    assertEquals(1, sol.ch)
    assertEquals("19:00:00", sol.time)
  }

//  3
@Test
def testCase3 = {
  val case3 =    List(
    TimePair("13:00:00","24:00:00"),
  TimePair("00:00:00","08:00:00"),
  TimePair("14:00:00","24:00:00"),
  TimePair("08:00:00","14:00:00"),
  TimePair("00:00:00","13:00:00"))

  val sol = MaxChannels.solve(case3)
  assertEquals(2, sol.ch)
  assertEquals("24:00:00", sol.time)
}

  //4
  @Test
  def testCase4 = {
    val case4 =    List(
  TimePair("20:30:00","21:00:00"))

    val sol = MaxChannels.solve(case4)
    assertEquals(1, sol.ch)
    assertEquals("00:30:00", sol.time)
  }

  //5
  @Test
  def testCase5 = {
    val case5 =    List(
      TimePair("08:13:54","14:13:55"))

    val sol = MaxChannels.solve(case5)
    assertEquals(1, sol.ch)
    assertEquals("06:00:01", sol.time)
  }

  //6
  @Test
  def testCase6 = {
    val case6 =    List(
      TimePair("03:51:49","11:59:53"),
      TimePair("06:20:56","14:44:05"))

    val sol = MaxChannels.solve(case6)
    assertEquals(2, sol.ch)
    assertEquals("05:38:57", sol.time)
  }

  //7
  @Test
  def testCase7 = {
    val case7 =    List(
        TimePair("00:00:00","23:59:59"),
        TimePair("00:00:00","23:59:59"),
        TimePair("00:00:00","23:59:59"))

    val sol = MaxChannels.solve(case7)
    assertEquals(3, sol.ch)
    assertEquals("23:59:59", sol.time)
  }

  //8
  @Test
  def testCase8 = {
    val case8 =    List(
        TimePair("04:58:50","11:21:42"),
        TimePair("01:54:53","03:40:18"),
        TimePair("04:58:57","08:33:37"),
        TimePair("09:44:00","10:54:13"))

    val sol = MaxChannels.solve(case8)
    assertEquals(2, sol.ch)
    assertEquals("04:44:53", sol.time)
  }

  //9
  @Test
  def testCase9 = {
    val case9 =    List(
        TimePair("10:52:33","18:50:04"),
        TimePair("08:20:56","14:08:33"),
        TimePair("03:53:20","11:04:05"),
        TimePair("07:53:38","13:15:12"),
        TimePair("05:25:22","09:49:02"))

    val sol = MaxChannels.solve(case9)
    assertEquals(4, sol.ch)
    assertEquals("01:39:38", sol.time)
  }

  //10
  @Test
  def testCase10 = {
    val case10 =    List(
        TimePair("08:12:28","13:25:57"),
        TimePair("05:26:53","08:35:53"),
        TimePair("00:52:26","08:00:34"),
        TimePair("02:16:56","02:58:29"),
        TimePair("05:34:15","12:49:54"))

    val sol = MaxChannels.solve(case10)
    assertEquals(3, sol.ch)
    assertEquals("02:49:44", sol.time)
  }

  //11
  @Test
  def testCase11= {
    val case11 =    List(
        TimePair("01:00:00","02:00:00"),
        TimePair("02:00:00","03:00:00"),
        TimePair("03:00:00","04:00:00"),
        TimePair("04:00:00","05:00:00"),
        TimePair("05:00:00","06:00:00"),
        TimePair("06:00:00","07:00:00"),
        TimePair("07:00:00","08:00:00"),
        TimePair("08:00:00","09:00:00"))

    val sol = MaxChannels.solve(case11)
    assertEquals(1, sol.ch)
    assertEquals("08:00:00", sol.time)
  }

  //5
  @Test
  def testCase12 = {
    val case12 =    List(
        TimePair("01:04:37","06:26:15"),
        TimePair("10:20:03","18:55:31"),
        TimePair("01:08:51","04:58:54"),
        TimePair("11:50:29","13:27:51"),
        TimePair("11:49:28","17:40:07"),
        TimePair("10:55:45","16:47:36"),
        TimePair("01:38:58","06:51:18"),
        TimePair("10:52:36","15:44:50"),
        TimePair("07:38:01","07:38:12"),
        TimePair("00:36:12","09:50:59"))

    val sol = MaxChannels.solve(case12)
    assertEquals(5, sol.ch)
    assertEquals("01:37:22", sol.time)
  }

}
