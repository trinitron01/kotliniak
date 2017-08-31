package com.bfs.kotliniak.base

class VariablesBasicTypesArrays2 {

  val myInt = 55
  val myLongConv = myInt.toLong()
  val myLong = 19L
  val myLongAgain: Long = 40
  val myFloat = 34.43F
  val myDouble = 45.78
  val myHexadecimal = 0x0F
  val myBinary = 0b010101


  var someProperty: String = "defaultValue"
    get() = field + " asdf"
    set(value) {
      field = value
    }

  val multipleStringLines = """
        This is first line
        This is second line
        This is third line """


  val name = "Chike"
  val message = "The first letter in my name is ${name.first()}" // The first letter in my name is C

  val myArray = arrayOf(23, 13, 23)


  val myArray3 = arrayOf<Int>(4, 5, 7, 3) // will not compile
  val myArray4 = intArrayOf(4, 5, 7, 3)  // will not compile
  val boolArray = booleanArrayOf(true, false);


  val numbersArray = Array(5,
      { i -> i * 2 }
      //lub arrayInitFunction()
      // lub { it *2 }
  )

  private fun arrayInitFunction() = {
    i: Int ->
    i * 2
  }

  fun test2() {
    val age = 40
    val anotherMessage = "You are ${if (age > 60) "old" else "young"}" // You are young

    val myArray = arrayOf(4, 5, 7, 3, "Chike", false)


    val (quartile, percentQuartile) = Pair(0, 0f)

//extension functions
    //Do

    "xFunxWithxKotlinx".countAmountOfX()


    require(true, { "Has to be true !" })


  }

  fun String.countAmountOfX(): Int {
    return length - replace("x", "").length
  }


}