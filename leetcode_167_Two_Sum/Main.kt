package leetcode_167_Two_Sum

class Running {
    fun twoSum(arr: IntArray, target: Int): IntArray {
        var lowIdx = 0
        var highIdx = arr.size - 1
        while (lowIdx < highIdx) {
            val sum = arr[lowIdx] + arr[highIdx]
            if (sum == target) {
                return intArrayOf(lowIdx + 1, highIdx + 1)
            } else if (sum < target) {
                ++lowIdx
            } else {
                --highIdx
            }
        }

        return intArrayOf()
    }
}

fun main() {
    // sorted array
    val input = arrayOf(
        intArrayOf(1, 2, 3, 4),
        intArrayOf(2, 7, 11, 15),
        intArrayOf(-1, 0),
//        intArrayOf(2, 3, -2, 4, -1),
    )

    Running().twoSum(input[1], 18).also { u ->
        println("v-->${u.toList()}")
    }
}