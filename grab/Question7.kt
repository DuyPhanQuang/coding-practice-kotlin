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

fun solution(input: IntArray): Int {
    if (input.size < 3) {
        return 0
    }
    var seen = 0
    while (seen < input.size - 1 && input[seen] < input[seen + 1]) {
        seen++
    }
    if (seen == 0 || seen == input.size - 1) {
        return 0
    }
    while (seen < input.size - 1 && input[seen] > input[seen + 1]) {
        seen++
    }

    return if (seen == input.size - 1) 1 else 0
}

fun main() {
    println(solution(intArrayOf(1,2,3,4,5,4,3,7)))
    println(solution(intArrayOf(1,2,3,4,7,6,5)))
    println(solution(intArrayOf(0,1,0)))
    println(solution(intArrayOf(0,2,1,0)))
}