package grab

/** condition
 peak can not is first or last and mountain has at least 3 element.
 * **/

/** idea
 traversing from left to right.
 if there is a mountain, we first move up from left end to the peak and then move down from peak
 to the right end. so one basic idea would be to scan the array from left to right
 and check strictly increasing and then decreasing order of elements.
 if can reach the end, it means equal than until the size of given input array, so valid mountain
**/

/** certainly, break down solution step by step
 *UP
 we start from left end and initialize variable climb to track the order of element
 now we check strictly increasing order and reach the mountain peak by running a loop.
 if element[climb] < element[climb+1] && climb < n-1 we are on the track of increasing order
 and keep moving up to the next element
 we stop running a loop if any one of condition become false
 by the end of loop, if peak presented at first of last element we return false
 *DOWN
 if peak presented at middle element, we running a loop from this position to check strictly decreasing order.
 if reach the end, input valid mountain, otherwise its not.

 // time complexity: 0(n) where n is a size of the input array
 // space complexity: 0(1) we are using constant extra space

**/
fun isValidMountain(arr: Array<Int>): Boolean {
    if (arr.size < 3) {
        return false
    }
    var climb = 0
    while (climb < arr.size-1 && arr[climb] < arr[climb+1]) {
        climb += 1
    }
    if (climb == 0 || climb == arr.size-1) {
        return false
    }
    while (climb < arr.size-1 && arr[climb]> arr[climb+1]) {
        climb += 1
    }
    return climb == arr.size-1
}

fun main() {
    println(isValidMountain(arrayOf(1,2,3,4,5,4,3,7)))
    println(isValidMountain(arrayOf(1,2,3,4,7,6,5)))
}