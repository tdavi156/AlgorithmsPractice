package com.example.algorithmspractice

// LeetCode problem 392. Is Subsequence
fun main() {

    val test1String1 = "abc" // example 1
    val test1String2 = "ahbgdc"

    val test2String1 = "axc" // example 2
    val test2String2 = "ahbgdc"

    val test3String1 = "aaabc" // many repeated letters
    val test3String2 = "ahbagdacbaaacaaa"

    val test4String1 = "aaaaa" // all same letter, missing in second string
    val test4String2 = "ahbagdac"

    val test5String1 = "aaaaa" // all same letter, present in second string
    val test5String2 = "ahbagdacaefgaxyz"

    val test6String1 = "abcdefg" // first string is larger
    val test6String2 = "abc"

    val test7String1 = "" // empty string
    val test7String2 = "abc"

    println("Test 1: abc + ahbgdc .. output: ${isSubsequence(test1String1, test1String2)}") // expected result: true
    println("Test 2: axc + ahbgdc .. output: ${isSubsequence(test2String1, test2String2)}") // expected result: false
    println("Test 3: aaabc + ahbagdacbaaacaaa .. output: ${isSubsequence(test3String1, test3String2)}") // expected result: true
    println("Test 4: aaaaa + ahbagdac .. output: ${isSubsequence(test4String1, test4String2)}") // expected result: false
    println("Test 5: aaaaa + ahbagdacaefgaxyz .. output: ${isSubsequence(test5String1, test5String2)}") // expected result: true
    println("Test 6: abcdefg + abc .. output: ${isSubsequence(test6String1, test6String2)}") // expected result: false
    println("Test 7: '' + abc .. output: ${isSubsequence(test7String1, test7String2)}") // expected result: true
}

fun isSubsequence(s1 : String, s2 : String) : Boolean {

    var currentIndex = 0

    s2.forEach { char ->
        if (s1.isEmpty()) return true
        if (char == s1[currentIndex]) {
            currentIndex++
        }
        if (currentIndex == s1.length) {
            return true
        }
    }
    return false
}