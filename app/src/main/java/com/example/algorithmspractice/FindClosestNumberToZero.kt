package com.example.algorithmspractice

import kotlin.math.abs

// LeetCode problem 2239. Find Closest Number to Zero
fun main() {

    val testArray1 : IntArray = intArrayOf(-4,-2,1,4,8) // example 1
    val testArray2 : IntArray = intArrayOf(2,-1,1) // example 2
    val testArray3 : IntArray = intArrayOf(2,1,-1) // negative number tie coming last
    val testArray4 : IntArray = intArrayOf(-2,-1,-4,-6,-1) // all negative numbers
    val testArray5 : IntArray = intArrayOf(2,1,-1,0) // including a 0
    val testArray6 : IntArray = intArrayOf(2,1,1,1,10) // all positive
    val testArray7 : IntArray = intArrayOf(15,4,12,16,22,-26,3,-4) // large gap of "wrong" numbers
    val testArray8 : IntArray = intArrayOf(3) // size of 1

    println("Test 1: [-4,-2,1,4,8] .. output: ${getClosestNumber(testArray1)}") // expected result: 1
    println("Test 2: [2,-1,1] .. output: ${getClosestNumber(testArray2)}") // expected result: 1
    println("Test 3: [2,1,-1] .. output: ${getClosestNumber(testArray3)}") // expected result: 1
    println("Test 4: [-2,-1,-4,-6,-1] .. output: ${getClosestNumber(testArray4)}") // expected result: -1
    println("Test 5: [2,1,-1,0] .. output: ${getClosestNumber(testArray5)}") // expected result: 0
    println("Test 6: [2,1,1,1,10] .. output: ${getClosestNumber(testArray6)}") // expected result: 1
    println("Test 7: [15,4,12,16,22,-26,3,-4] .. output: ${getClosestNumber(testArray7)}") // expected result: 3
    println("Test 8: [3] .. output: ${getClosestNumber(testArray8)}") // expected result: 3
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

