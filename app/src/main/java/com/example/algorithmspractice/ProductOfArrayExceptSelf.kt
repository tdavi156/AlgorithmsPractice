package com.example.algorithmspractice

// LeetCode problem 238. Product of Array Except Self
fun main() {

    val testArray1 = intArrayOf(1,2,3,4) // example 1
    val testArray2 = intArrayOf(-1,1,0,-3,3) // example 2
    val testArray3 = intArrayOf(4,7) // only 2 inputs
    val testArray4 = intArrayOf(4,3,2,1) // descending values
    val testArray5 = intArrayOf(1,2,3,0,5,6,0,8,9) // 2 zero values
    val testArray6 = intArrayOf(1,-1,2,-2,3,-3) // alternating negative numbers

    println("Test 1: [1,2,3,4] .. output: ${productExceptSelf(testArray1).joinToString()}") // expected result: [24,12,8,6]
    println("Test 2: [-1,1,0,-3,3] .. output: ${productExceptSelf(testArray2).joinToString()}") // expected result: [0,0,9,0,0]
    println("Test 3: [4,7] .. output: ${productExceptSelf(testArray3).joinToString()}") // expected result: [7,4]
    println("Test 4: [4,3,2,1] .. output: ${productExceptSelf(testArray4).joinToString()}") // expected result: [6,8,12,24]
    println("Test 5: [1,2,3,0,5,6,0,8,9] .. output: ${productExceptSelf(testArray5).joinToString()}") // expected result: [0,0,0,0,0,0,0,0,0]
    println("Test 6: [1,-1,2,-2,3,-3] .. output: ${productExceptSelf(testArray6).joinToString()}") // expected result: [-36,36,-18,18,-12,12]
}

fun productExceptSelf(nums : IntArray) : IntArray {

    val productArray = IntArray(nums.size)
    var leftProduct = 1
    var rightProduct = 1

    nums.indices.forEach { index ->
        productArray[index] = leftProduct
        leftProduct *= nums[index]
    }

    nums.indices.forEach { index ->
        productArray[nums.size - index - 1] *= rightProduct
        rightProduct *= nums[nums.size - index - 1]
    }

    return productArray
}