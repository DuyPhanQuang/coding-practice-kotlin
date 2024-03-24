package grab

/* Question 6
6/ Given a non-negative number represented as an array of digits,
add 1 to the number ( increment the number represented by the digits ).
The digits are stored such that the most significant digit is at the head of the list.

Example:

If the vector has [1, 2, 3]

the returned vector should be [1, 2, 4]

as 123 + 1 = 124.
return [1, 2, 4]

[0, 0, 0]
-> [1] or [0, 0, 1]
* */

// Certainly! Let's delve into the main logic of the solution step by step:
// initialization:
// The function starts by initializing n, which stores the number of elements in the digits array. This will be useful for iterating through the array.
// Adding 1 to the Least Significant Digit:
// Since the digits are stored in such a way that the most significant digit is at the head of the list, we start by adding 1 to the least significant digit, which is at index n - 1.
// Handling Carry Over:
// After adding 1 to the least significant digit, we iterate through the array in reverse order, starting from the least significant digit.
// We add any carry from the previous digit to the current digit, calculate the new carry, and update the current digit to ensure it remains between 0 and 9.
// Adding New Most Significant Digit If Needed:
// If there's still a carry after the loop, it means the original array was not large enough to represent the incremented number. In this case, we need to add a new most significant digit.
// We create a new array with one more element than the original array, place the carry in the most significant digit position, and copy the remaining digits from the original array to the new array.
// Returning the Result:
// Finally, the function returns the modified array, either the original digits array with the incremented value or the newly created array with the additional most significant digit.
// The key insight here is to increment the least significant digit first and then propagate any carry over to the more significant digits while ensuring that each digit remains within the range of 0 to 9.
// This approach allows us to handle the addition of 1 to the number represented by the array of digits efficiently.

// time complexity: O(n), where n is the number of digits in the input array.
// space complexity: also O(n), We use a constant amount of extra space for variables like n and carry

fun plusOne(digits: IntArray): IntArray {
    val n = digits.size
    // adding 1 to the least significant digit
    digits[n - 1]++
    // Handling carry over
    var carry = 0
    for (i in n - 1 downTo 0) {
        digits[i] += carry
        carry = digits[i] / 10
        digits[i] %= 10
    }
    // if there's still carry after the iteration, add a new most significant digit
    if (carry > 0) {
        val result = IntArray(n + 1)
        result[0] = carry
        for (i in 1 until n + 1) {
            result[i] = digits[i - 1]
        }
        return result
    }

    return digits
}

fun main() {
    println(plusOne(intArrayOf(1, 2, 3)).toList())
    println(plusOne(intArrayOf(1, 5, 9)).toList())
    println(plusOne(intArrayOf(1, 9, 9)).toList())
    println(plusOne(intArrayOf(9, 9, 9)).toList())
    println(plusOne(intArrayOf(0, 0, 0)).toList())
}