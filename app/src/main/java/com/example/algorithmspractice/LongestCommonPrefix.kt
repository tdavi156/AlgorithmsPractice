package com.example.algorithmspractice

import kotlin.math.min

// LeetCode problem 14. Longest Common Prefix
fun main() {

    val testArray1 : Array<String> = arrayOf("flower", "flow", "flight") // example 1
    val testArray2 : Array<String> = arrayOf("dog", "racecar", "car") // example 2
    val testArray3 : Array<String> = arrayOf("", "abc") // contains empty string
    val testArray4 : Array<String> = arrayOf("dog", "dog", "dog") // contains same string
    val testArray5 : Array<String> = arrayOf("loud", "sound", "louder", "bound") // matching middle characters

    println("Test 1: [flower, flow, flight] .. output: ${longestCommonPrefix(testArray1)}") // expected result: fl
    println("Test 2: [dog, racecar, car] .. output: ${longestCommonPrefix(testArray2)}") // expected result: ' '
    println("Test 2: [' ', abc] .. output: ${longestCommonPrefix(testArray3)}") // expected result: ' '
    println("Test 2: [dog, dog, dog] .. output: ${longestCommonPrefix(testArray4)}") // expected result: dog
    println("Test 2: [loud, sound, louder, bound] .. output: ${longestCommonPrefix(testArray5)}") // expected result: ' '
}

fun longestCommonPrefix(strings : Array<String>) : String {

    if (strings.isEmpty()) return ""

    var commonPrefix = strings[0]

    strings.forEach { string ->
        val minString = min(commonPrefix.length, string.length)
        for (i in 0 ..<minString) {
            if (commonPrefix[i] != string[i]) {
                commonPrefix = commonPrefix.substring(0, i)
                return@forEach
            }
        }
    }

    return commonPrefix
}