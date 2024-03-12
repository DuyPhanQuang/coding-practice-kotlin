package valid_mountain

fun main() {
    val input: Array<Int> = arrayOf(1,2,3,4,7,6,5)
    println("check valid mountain --> ${isValidMountain(input)}")
}

/* solution
 peak can not is first or last and mountain has at least 3 element.
 traversing from left to right

 *UP
 we start from left end and initialize variable climb to track the order of element
 now we check strictly increasing order and reach the mountain peak by running a loop.
 if element[climb] < element[climb+1] && climb < n-1 we are on the track of increasing order and keep moving up to the next element
 we stop running a loop if any one of condition become false
 by the end of loop, if peak presented at first of last element we return false
 *DOWN
 if peak presented at middle element, we running a loop from this position to check strictly decreasing order.
 if reach the end, input valid mountain, otherwise its not.

* */
fun isValidMountain(arr: Array<Int>): Boolean {
    if (arr.size < 3) {
        return false
    }

    var temp = 0

    while (temp < arr.size-1 && arr[temp] < arr[temp+1]) {
        temp += 1
    }
    if (temp == 0 || temp == arr.size-1) {
        return false
    }
    while (temp < arr.size-1 && arr[temp]> arr[temp+1]) {
        temp += 1
    }

    return temp == arr.size-1
}