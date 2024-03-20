package grab

/* QUESTION 4
Given an array of integers nums and an integer target, return  two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

Example 1:
Input: nums = [2,7,11,15], target = 9
Output: [2,7]
Explanation: Because nums[0] + nums[1] == 9, we return [2, 7].

Example 2:
Input: nums = [3,2,4], target = 6
Output: [2,4]

Example 3:
Input: nums = [3,3], target = 6
Output: [3,3]
 */

fun solution(arr: IntArray, target: Int):IntArray {
    // initialize an hash map as `numIndices` is created to store the indices of elements encounter so far
    // during the iteration.
    // the keys of map represent the elements of the array and the values of map represent their indices.
    val numIndices = HashMap<Int, Int>()
    // we running a simple loop for iterate through the indices of arr
    for (i in arr.indices) {
        // calculate a temp need to reach the target by subtracting the current element from the target
        val temp = target - arr[i]

        // check if temp is found in numIndices, it means that there exists a pair of elements whose sum
        // is equal to the target. in this case, should return an array containing the indices of two elements.
        if (temp in numIndices) {
            return intArrayOf(arr[numIndices[temp]!!], arr[i])
        }
        // otherwise, if the temp is not found,it means the current elements have not been pair with any
        // previous elements to react the target yet, so the index of current elements is stored in the numIndices
        // with the element itself as the key
        numIndices[arr[i]] = i
    }

    // no pair of elements sum up to target
    return intArrayOf()
}

fun main() {
    println(solution(intArrayOf(2,7,11,15), 9).toList())
    println(solution(intArrayOf(3,2,4), 6).toList())
    println(solution(intArrayOf(3,3), 6).toList())
}