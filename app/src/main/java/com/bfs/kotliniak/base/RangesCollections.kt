package com.bfs.kotliniak.base

object RangesCollections {
  fun test() {
    val oneToFive: IntRange = 1.rangeTo(5)


    val oneToTenStep = 1..10 step 2 // 1, 3, 5, 7, 9


/*
    val stringList: ArrayList<String> = arrayListOf<String>("Hello", "You", "There")
    stringList.add("sd")
*/


    val intsSortedSet: java.util.TreeSet<Int> = sortedSetOf(4, 1, 7, 2)
    intsSortedSet.add(6)
    intsSortedSet.remove(1)
    intsSortedSet.clear()


    val callingCodesMap: Map<Int, String> = mapOf(234 to "Nigeria", 1 to "USA", 233 to "Ghana")
    for ((key, value) in callingCodesMap) {
      println("$key is the calling code for $value")
    }
    print(callingCodesMap[234]) // Nigeria
    val utemm = Pair<Int, String>(1, "ads")
    val plus = callingCodesMap.plus(utemm)


    val currenciesMutableMap: MutableMap<String, String> = mutableMapOf("Naira" to "Nigeria",
        "Dollars" to "USA", "Pounds" to "UK")
    println("Countries are ${currenciesMutableMap.values}") // Countries are [Nigeria, USA, UK]
    println(
        "Currencies are ${currenciesMutableMap.keys}") // Currencies are [Naira, Dollars, Pounds]
    currenciesMutableMap.put("Cedi", "Ghana")
    currenciesMutableMap.remove("Dollars")


    val stringList: List<String> = listOf("in", "the", "club")
    print(stringList.last()) // will print "club"

// given a predicate
    print(stringList.last { it.length == 3 }) // will print "the"

    val intSet: Set<Int> = setOf(3, 5, 6, 6, 6, 3)
    print(intSet.last()) // will print 6

  }
}