package com.example.algorithmspractice

// LeetCode problem 14. Longest Common Prefix
fun main() {

    val testArray1 : Array<String> = arrayOf("flower", "flow", "flight") // example 1
    val testArray2 : Array<String> = arrayOf("dog", "racecar", "car") // example 2

    println("Test 1: [flower, flow, flight] .. output: ${longestCommonPrefix(testArray1)}") // expected result: fl
    println("Test 2: [dog, racecar, car] .. output: ${longestCommonPrefix(testArray2)}") // expected result: ' '
}

fun longestCommonPrefix(strings : Array<String>) : String {

    return ""
}