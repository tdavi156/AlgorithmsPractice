package com.example.algorithmspractice

// LeetCode problem 13. Roman to Integer
fun main() {

    val testString1 = "III" // example 1
    val testString2 = "LVIII" // example 2
    val testString3 = "MCMXCIV" // example 3
    val testString4 = "X" // single character number
    val testString5 = "MDCLXVI" // all characters
    val testString6 = "LIXX" // nice
    val testString7 = "MMMCMXCIX" // max number

    println("Test 1: III .. output: ${romanToInt(testString1)}") // expected result: 3
    println("Test 2: LVIII .. output: ${romanToInt(testString2)}") // expected result: 58
    println("Test 3: MCMXCIV .. output: ${romanToInt(testString3)}") // expected result: 1994
    println("Test 4: X .. output: ${romanToInt(testString4)}") // expected result: 10
    println("Test 5: MDCLXVI .. output: ${romanToInt(testString5)}") // expected result: 1666
    println("Test 6: LIXX .. output: ${romanToInt(testString6)}") // expected result: 69
    println("Test 7: MMMCMXCIX .. output: ${romanToInt(testString7)}") // expected result: 3999
}

fun romanToInt(romanNumber : String) : Int {

    var total = 0
    val romanList = romanNumber.toList()
    var currentChar: Char
    var nextChar: Char

    for (i in romanList.indices) {
        currentChar = romanList[i]
        nextChar = if (i < romanList.size - 1) romanList[i + 1] else 'Z'

        when (currentChar) {
            'I' -> {
                if (nextChar == 'V' || nextChar == 'X') {
                    total -= 1
                } else {
                    total += 1
                }
            }
            'V' -> { total += 5 }
            'X' -> {
                if (nextChar == 'L' || nextChar == 'C') {
                    total -= 10
                } else {
                    total += 10
                }
            }
            'L' -> { total += 50 }
            'C' -> {
                if (nextChar == 'D' || nextChar == 'M') {
                    total -= 100
                } else {
                    total += 100
                }
            }
            'D' -> { total += 500 }
            'M' -> {
                total += 1000
            }
        }
    }

    return total
}