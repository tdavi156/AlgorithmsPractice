package com.example.algorithmspractice

// LeetCode problem 771. Jewels and Stones
fun main() {

    val test1String1 = "aA" // example 1
    val test1String2 = "aAAbbbb"

    val test2String1 = "z" // example 2
    val test2String2 = "ZZ"

    val test3String1 = "aAbB" // every character matches
    val test3String2 = "aAAbbbb"

    val test4String1 = "aAbBcCdDeEfFgGhHiIjJkKlLmMnNoOpPqQrRsStTuUvVwWxXyYzZ" // long jewels string
    val test4String2 = "abcdefg"

    val test5String1 = "a" // single character strings
    val test5String2 = "a"

    println("Test 1: aA .. aAAbbbb .. output: ${numJewelsInStones(test1String1, test1String2)}") // expected result: 3
    println("Test 2: z .. ZZ .. output: ${numJewelsInStones(test2String1, test2String2)}") // expected result: 0
    println("Test 3: aAbB .. aAAbbbb .. output: ${numJewelsInStones(test3String1, test3String2)}") // expected result: 7
    println("Test 4: aAbBcCdDeEfFgGhHiIjJkKlLmMnNoOpPqQrRsStTuUvVwWxXyYzZ .. abcdefg .. output: ${numJewelsInStones(test4String1, test4String2)}") // expected result: 7
    println("Test 5: a .. a .. output: ${numJewelsInStones(test5String1, test5String2)}") // expected result: 1
}

fun numJewelsInStones(jewels : String, stones : String) : Int {

    val jewelsSet : MutableSet<Char> = mutableSetOf()
    jewels.forEach { char ->
        jewelsSet.add(char)
    }

    var jewelsCount = 0
    stones.forEach { char ->
        if (jewelsSet.contains(char)) {
            jewelsCount++
        }
    }

    return jewelsCount
}