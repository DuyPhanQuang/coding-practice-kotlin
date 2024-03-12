package leetcode_152_Maximum_Product_Subarray

class Running {
    fun maximumProduct(arr: IntArray): Int {
        var finalMax = arr[0]
        var currMin = arr[0]
        var currMax = arr[0]
        for (i in 1 until arr.size) {
            val tempMax = Math.max(Math.max(currMax * arr[i], currMin * arr[i]), arr[i])
            currMin = Math.min(arr[i], Math.min(currMax * arr[i], currMin * arr[i]))
            currMax = tempMax
            finalMax = Math.max(finalMax, currMax)
            println("$finalMax $currMin $currMax")
        }

        return finalMax
    }
}

fun main() {
    val input = arrayOf(
        intArrayOf(2,3,-2,4),
//        intArrayOf(2, 3, -2, 4, -1),
//        intArrayOf(2, 3, -2, 4, -1, 2),
//        intArrayOf(-2, 0, -1),
//        intArrayOf(0, 2),
//        intArrayOf(2, -5, -2, -4, 3),
    )

    input.forEach {
        Running().maximumProduct(it).let(::println)
    }
}