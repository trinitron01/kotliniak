package com.bfs.kotliniak.dataclasses

object MonthYearTests {

  fun test() {
    val monthYear = MonthYear(2, 2017)

    val nextMonth = monthYear.copy(month = 6)

    val now = MonthYear(month = 5, year = 2017)
    val toString = now.toString()

  }
}
