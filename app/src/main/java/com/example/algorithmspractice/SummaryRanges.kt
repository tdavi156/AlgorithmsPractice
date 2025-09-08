package com.example.algorithmspractice

// LeetCode problem 228. Summary Ranges
fun main() {

    val testArray1 = intArrayOf(0,1,2,4,5,7) // example 1
    val testArray2 = intArrayOf(0,2,3,4,6,8,9) // example 2
    val testArray3 = intArrayOf() // empty array
    val testArray4 = intArrayOf(Int.MIN_VALUE,4,5,6,Int.MAX_VALUE) // min and max int values
    val testArray5 = intArrayOf(0,4,8,12,16,20) // no combined ranges
    val testArray6 = intArrayOf(0,1,2,3,4,5) // all 1 range

    println("Test 1: [0,1,2,4,5,7] .. output: ${summaryRanges(testArray1)}") // expected result: ["0->2","4->5","7"]
    println("Test 2: [0,2,3,4,6,8,9] .. output: ${summaryRanges(testArray2)}") // expected result: ["0","2->4","6","8->9"]
    println("Test 3: [] .. output: ${summaryRanges(testArray3)}") // expected result: []
    println("Test 4: [MIN,4,5,6,MAX] .. output: ${summaryRanges(testArray4)}") // expected result: ["MIN","4->6","MAX"]
    println("Test 5: [0,4,8,12,16,20] .. output: ${summaryRanges(testArray5)}") // expected result: ["0","4","8","12","16","20"]
    println("Test 6: [0,1,2,3,4,5] .. output: ${summaryRanges(testArray6)}") // expected result: ["0->5"]
}

fun summaryRanges(nums : IntArray) : List<String> {

    if (nums.isEmpty()) return listOf("")

    val stringList = ArrayList<String>()
    var rangeMin = nums[0]
    var rangeMax = nums[0]

    for (i in nums.indices) {
        if (nums[i] == rangeMax + 1) {
            rangeMax = nums[i]
        }

        if (i == nums.size - 1) {
            if (rangeMin == rangeMax) {
                stringList.add(nums[i].toString())
            } else {
                stringList.add("$rangeMin->$rangeMax")
            }
            return stringList
        }

        if (nums[i] + 1 != nums[i + 1]) {
            if (rangeMin == rangeMax) {
                stringList.add(nums[i].toString())
            } else {
                stringList.add("$rangeMin->$rangeMax")
            }

            rangeMin = nums[i + 1]
            rangeMax = nums[i + 1]
        }
    }

    return stringList
}