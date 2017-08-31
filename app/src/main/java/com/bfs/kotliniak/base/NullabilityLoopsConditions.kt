package com.bfs.kotliniak.base

import android.util.Log

object NullabilityLoopsConditions {
  val tag = "TAG"
  fun test() {
    //val name: String = null // will not compile

    val nullable: String? = null // will compile

    var nullableString: String? = null

    log(nullableString) // will compile and print "null"


    nullableString = null
    val len: Int? = nullableString?.length
    print(len) // will compile and print "null"


    val username = null
    val name: String = username ?: "No name"
    print(name) // will compile and print "No name"
  }

  private fun log(v: String?) {
    Log.d(tag, "" + v)
  }

  fun testLoops() {
    for (a in 1..5) {
      print("$a ") // will print  1 2 3 4 5
    }

    val numbersArray = intArrayOf(1, 2, 3, 4, 5)
    val withIndex = numbersArray.withIndex()
    for ((index, value) in withIndex) {
      log("$index index value is $value\n")
    }

    val numbers1 = intArrayOf(1, 2, 3, 4, 5)
    for (index in numbers1.indices) {
      log("$index index value is ${numbers1[index]}\n")
    }


/*
    val number = 20
    if (number is Int) {
      log("$number is an integer")
    }
*/


    val number = 13


    val result = if (number % 2 == 0) {
      "Divisible by 2"
      "Number is $number" // only this string is returned if executed
    } else {
      "Not divisible by 2"
      "Number is $number"
    }
  }
}