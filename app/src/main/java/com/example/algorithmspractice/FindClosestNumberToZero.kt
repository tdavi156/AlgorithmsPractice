package com.example.algorithmspractice

import kotlin.math.abs

fun main() {

    val testArray1 : IntArray = intArrayOf(-4,-2,1,4,8)
    val testArray2 : IntArray = intArrayOf(2,-1,1)
    val testArray3 : IntArray = intArrayOf(2,1,-1)
    val testArray4 : IntArray = intArrayOf(-2,-1,-4,-6,-1)
    val testArray5 : IntArray = intArrayOf(2,1,-1,0)
    val testArray6 : IntArray = intArrayOf(2,1,1,1,10)
    val testArray7 : IntArray = intArrayOf(15,4,12,16,22,-26,3,-4)
    val testArray8 : IntArray = intArrayOf(3)

    println("Test 1: [-4,-2,1,4,8] .. output: ${getClosestNumber(testArray1)}")
    println("Test 2: [2,-1,1] .. output: ${getClosestNumber(testArray2)}")
    println("Test 3: [2,1,-1] .. output: ${getClosestNumber(testArray3)}")
    println("Test 4: [-2,-1,-4,-6,-1] .. output: ${getClosestNumber(testArray4)}")
    println("Test 5: [2,1,-1,0] .. output: ${getClosestNumber(testArray5)}")
    println("Test 6: [2,1,1,1,10] .. output: ${getClosestNumber(testArray6)}")
    println("Test 7: [15,4,12,16,22,-26,3,-4] .. output: ${getClosestNumber(testArray7)}")
    println("Test 8: [3] .. output: ${getClosestNumber(testArray8)}")
}

fun getClosestNumber(numbers : IntArray) : Int {

    var currentIndex = 0
    var currentClosestNumber : Int = abs(numbers[currentIndex])

    numbers.forEachIndexed { index, number ->
        if (abs(number) < currentClosestNumber || ((abs(number) == currentClosestNumber && number > numbers[currentIndex]))) {
            currentClosestNumber = abs(number)
            currentIndex = index
        }
    }
    return numbers[currentIndex]
}

