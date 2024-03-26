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

/** sub-problem
// iterate through the input array
// calculate complement
// check complement exist if it does, return value of indices elements
// store indices in a data structure
// repeat until solution found
**/

/** idea
 * using a hashmap to store the indices of elements as we iterate through an input array.
 * **/

/** Certainly, let me break down solution
- hash map for index storage: create a hash map is used to store the indices of elements encountered
while iterating through the array. this hash map will help in quickly determining if a complement
exists for the current element to react the target
- iteration through input array: running a loop and at each iteration,
it calculate the complement need to achieve the target sum.
- checking for complement: for each element in array, check if the complement(the difference between
the target and current element) exist in the hashmap.if it does, it means there exists a pair of elements
whose sum is equal to the target. in this case, the function immediately return an array containing
the value of these two elements.
- store element indices: otherwise, if the complement is not found in the hash map, it means the current
element have not been paired with any previous elements to reach the target yet. so the index of current element
is stored in the hash map with the element itself as the key.
- repeat until solution found: Continue iterating through the array until a solution is found (
i.e., until a pair of elements sum up to the target) or until the end of the array is reached.
**/

/**
 * time complexity: 0(n) where n is the number of elements in the input array
 * space complexity: 0(n) where n is the number of elements in the input array
 **/

fun solution(arr: IntArray, target: Int): IntArray {
    val numIndices = HashMap<Int, Int>()
    for (i in arr.indices) {
        val temp = target - arr[i]
        if (temp in numIndices) {
            return intArrayOf(arr[numIndices[temp]!!], arr[i])
        }
        numIndices[arr[i]] = i
    }

    return intArrayOf()
}

fun main() {
    println(solution(intArrayOf(2,7,11,15), 9).toList())
    println(solution(intArrayOf(3,2,4), 6).toList())
    println(solution(intArrayOf(3,3), 6).toList())
}