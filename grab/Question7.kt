package grab

import valid_mountain.isValidMountain

/* 7/ Let's call an array A a mountain if the following properties hold:
A.length >= 3
There exists some 0 < i < A.length - 1 such that A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1]
Given an array that is definitely a mountain, return any i such that A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1].
Example 1:
Input: [0,1,0]
Output: 1

Example 2:
Input: [0,2,1,0]
Output: 1
*/

/** the main logic of this solution to iterate through the input array and find the index
 * of the peak element which satisfies the conditions of being a mountain
 * Certainly, break down a solution step by step:
 * 1. we initialize a peak index assuming is at the beginning of the input array.
 * 2. we iterate through the input array has position i starting from 1 to n-1
 * where n is the length of given input array.
 * for each element at i, we compare it with the element at the current peak index.
 * if element at i greater than element at peak, we need to update peak index to i.
 * continue this process until the end of input array is reached.
 * **/

// time complexity: 0(n)
// space complexity: 0(1)

private fun solution(input: IntArray): Int {
    var peak = 0
    for (i in 1 until input.size) {
        if (input[i] > input[peak]) {
            peak = i
        }
    }
    return peak
}

fun main() {
    println(solution(intArrayOf(0,1,0)))
    println(solution(intArrayOf(0,2,1,0)))
}