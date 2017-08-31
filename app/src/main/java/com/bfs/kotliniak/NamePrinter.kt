package com.bfs.kotliniak

import kotlin.system.measureTimeMillis

class NamePrinter(val firstName: String, val lastName: String) {
  val fullName: String by lazy { "$firstName $lastName" }

  fun print() {
    println(fullName)

    val measureTimeMillis = measureTimeMillis { print("Hello") }

  }
}