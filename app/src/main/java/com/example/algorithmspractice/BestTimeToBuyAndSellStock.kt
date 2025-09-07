package com.example.algorithmspractice

// LeetCode problem 121. Best Time to Buy and Sell Stock
fun main() {

    val testArray1 = intArrayOf(7,1,5,3,6,4) // example 1
    val testArray2 = intArrayOf(7,6,4,3,1) // example 2
    val testArray3 = intArrayOf(1,3,6,4,4,4,3,10) // sell price changed at last index
    val testArray4 = intArrayOf(3,6,1,2,2,2) // lower sell price, but not greater profit
    val testArray5 = intArrayOf(3) // single entry
    val testArray6 = intArrayOf(3,8) // simple case
    val testArray7 = intArrayOf(8,4) // simple case, no profit
    val testArray8 = intArrayOf(5,5,5,5,5) // same price every day

    println("Test 1: [7,1,5,3,6,4] .. output: ${maxProfit(testArray1)}") // expected result: 5
    println("Test 2: [7,6,4,3,1] .. output: ${maxProfit(testArray2)}") // expected result: 0
    println("Test 3: [1,3,6,4,4,4,3,10] .. output: ${maxProfit(testArray3)}") // expected result: 9
    println("Test 4: [3,6,1,2,2,2] .. output: ${maxProfit(testArray4)}") // expected result: 3
    println("Test 5: [3] .. output: ${maxProfit(testArray5)}") // expected result: 0
    println("Test 6: [3,8] .. output: ${maxProfit(testArray6)}") // expected result: 5
    println("Test 7: [8,4] .. output: ${maxProfit(testArray7)}") // expected result: 0
    println("Test 8: [5,5,5,5,5] .. output: ${maxProfit(testArray8)}") // expected result: 0
}

fun maxProfit(prices : IntArray) : Int {

    if (prices.size == 1) return 0

    var buyIndex = 0
    var sellIndex = 1
    var currentProfit = prices[sellIndex] - prices[buyIndex]

    for (i in prices.indices) {
        if ((i < prices.size - 1) && prices[i] < prices[buyIndex]) {
            buyIndex = i
            sellIndex = i+1
            if ((prices[sellIndex] - prices[buyIndex]) > currentProfit) {
                currentProfit = prices[sellIndex] - prices[buyIndex]
            }
        }
        if (prices[i] > prices[sellIndex]) {
            sellIndex = i
            currentProfit = prices[sellIndex] - prices[buyIndex]
        }
    }

    return if (currentProfit >= 0) currentProfit else 0
}