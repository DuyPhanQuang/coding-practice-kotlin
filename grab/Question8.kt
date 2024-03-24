package grab

/*
You are given a 0-indexed integer array arr, and an m x n integer matrix mat. arr and mat both contain all the integers in the range [1, m * n].

Go through each index i in arr starting from index 0 and paint the cell in mat containing the integer arr[i].

Return the smallest index i at which either a row or a column will be completely painted in mat.


Input: arr = [1,3,4,2], mat = [[1,4],[2,3]]
Output: 2
Explanation: The moves are shown in order, and both the first row and second column of the matrix become fully painted at arr[2].


Input: arr = [2,8,7,4,1,3,5,6,9], mat = [[3,2,5],[1,4,6],[8,7,9]]
Output: 3
Explanation: The second column becomes fully painted at arr[3].
 */

fun solution(input: IntArray, mat: Array<IntArray>): Int {
    val m = mat.size
    val n = mat[0].size
    val paintedRows = mutableSetOf<Int>()
    val paintedColumns = mutableSetOf<Int>()
    for ((index, num) in input.withIndex()) {
        val adjustNum = num - 1
        val row = adjustNum / n
        val column = adjustNum % n
        // paint the cell
        mat[row][column] = 0

        paintedRows.add(row)
        paintedColumns.add(column)
        // complete painted
        if (paintedRows.size == m || paintedColumns.size == n) {
            return index + 1
        }
    }

    return -1
}

fun main() {
    val arr1 = intArrayOf(1, 3, 4, 2)
    val mat1 = arrayOf(intArrayOf(1, 4), intArrayOf(2, 3))
    println(solution(arr1, mat1))

    val arr2 = intArrayOf(2, 8, 7, 4, 1, 3, 5, 6, 9)
    val mat2 = arrayOf(intArrayOf(3, 2, 5), intArrayOf(1, 4, 6), intArrayOf(8, 7, 9))
    println(solution(arr2, mat2))
}