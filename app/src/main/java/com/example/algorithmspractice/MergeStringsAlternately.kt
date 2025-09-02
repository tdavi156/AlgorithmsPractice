package com.example.algorithmspractice

// LeetCode problem 1768. Merge Strings Alternately
fun main() {

    val test1String1 = "abc" // example 1
    val test1String2 = "pqr"

    val test2String1 = "ab" // example 2
    val test2String2 = "pqrs"

    val test3String1 = "abcd" // example 3
    val test3String2 = "pq"

    val test4String1 = "a" // single character word followed by long word
    val test4String2 = "pqrstuvwxyz"

    val test5String1 = "abcdefghijk" // long word followed by single character word
    val test5String2 = "z"

    val test6String1 = "a" // both words are single character
    val test6String2 = "z"

    val test7String1 = "abcdefghijklmnopqrstuvwxyz" // both words are long
    val test7String2 = "abcdefghijklmnopqrstuvwxyz"

    println("Test 1: abc + pqr .. output: ${mergeAlternately(test1String1, test1String2)}") // expected result: apbqcr
    println("Test 2: ab + pqrs .. output: ${mergeAlternately(test2String1, test2String2)}") // expected result: apbqrs
    println("Test 3: abcd + pq .. output: ${mergeAlternately(test3String1, test3String2)}") // expected result: apbqcd
    println("Test 4: a + pqrstuvwxyz .. output: ${mergeAlternately(test4String1, test4String2)}") // expected result: apqrstuvwxyz
    println("Test 5: abcdefghijk + z .. output: ${mergeAlternately(test5String1, test5String2)}") // expected result: azbcdefghijk
    println("Test 6: a + z .. output: ${mergeAlternately(test6String1, test6String2)}") // expected result: az
    println("Test 6: abcdefghijklmnopqrstuvwxyz + abcdefghijklmnopqrstuvwxyz .. output: ${mergeAlternately(test7String1, test7String2)}") // expected result: zippered alphabet
}

fun mergeAlternately(word1 : String, word2 : String) : String {

    val smallerWord : String
    val biggerWord : String
    val mergedStringList : MutableList<Char> = mutableListOf()
    val stringBuilder = StringBuilder()

    if (word1.length <= word2.length) {
        smallerWord = word1
        biggerWord = word2
    } else {
        smallerWord = word2
        biggerWord = word1
    }

    for (i in smallerWord.indices) {
        mergedStringList.add(word1[i])
        mergedStringList.add(word2[i])
    }

    for (i in smallerWord.length..<biggerWord.length) {
        mergedStringList.add(biggerWord[i])
    }

    mergedStringList.forEach { char ->
        stringBuilder.append(char)
    }

    return stringBuilder.toString()
}