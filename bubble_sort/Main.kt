package bubble_sort
import TestCases.unsortedArrs

fun main() {
    unsortedArrs.forEach { it ->
        bubbleSort(it)
        it.forEach {
            print(it)
            print(" ")
        }
        println("***")
    }
}

fun bubbleSort(arr: IntArray) {
    for (i in 0..arr.size - 2) {
        for (j in i+1 until arr.size) {
            if (arr[i] > arr[j]) {
                val temp = arr[i]
                arr[i] = arr[j]
                arr[j] = temp
            }
        }
    }
}

fun optimized(arr: IntArray) {
    do {
        var swapped = false
        for (i in 0..arr.size - 2) {
            if (arr[i] > arr[i+1]) {
                val temp = arr[i]
                arr[i] = arr[i+1]
                arr[i+1] = temp
                swapped = true
            }
        }
    } while (swapped)
}