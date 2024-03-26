package grab

/* QUESTION 1
1/You are given a string of the English alphabet. You must split this string into a minimal number of substrings in such a way that no letter occurs more than once in each substring.
For example, here are some correct splits of the string "abacdec": ('a', 'bac', 'dec'), ('a', bacd', 'ec') and ('ab', 'ac', 'dec').
* */

// question type: Find minimum number of Substrings with unique characters

// to solve this problem, we need to keep track of the last occurrence of each character in the string
// whenever we encounter a repeated character, we know that the current substrings contain a character
// that is repeated so we need to start new substring. we can determine the start of the new substring
// by setting value of start to the index of repeat character. we also increased the value of answer
// to indicate that we have started a new substring.

// Certainly, let's break down solution step by step:
// Create an array list of size 26 to store the last index of each character (initially set to -1).
// Initialize the starting index of the current substring to 0.
// Initialize the answer variable ans to 1.
// Iterate through the given string s:
// Get the index of the current character in the array by subtracting ‘a’ from it.
// Check if the current character is already present in the current substring by
// comparing its last index with the starting index of the current substring.
// If it is, increment the answer variable ans and update the starting index of the new substring
// to the current index.
// Update the last index of the current character in the array with the current index.
// Return the answer variable ans, which gives the minimum number of substrings required.

// Time Complexity: O(n) where n is the length of the input string.
// Auxiliary Space: O(1)
private fun solution(s: String): Int {
    // Create an array to store the last index of each character
    val last = IntArray(26) { -1 }
    // Initialize the starting index of the current substring to 0
    var start = 0
    // Initialize the answer variable to 1
    var answer = 1
    for (i in s.indices) {
        // Get the index of the current character in the array
        val index = s[i] - 'a'
        // Check if the current character is already present in the current substring
        if (last[index] >= start) {
            // If it is, increment the answer variable
            // and update the starting index of the new substring
            answer++
            start = i
        }
        // Update the last index of the current character
        last[index] = i
    }
    // Return the answer variable, which gives the
    // minimum number of substrings required
    return answer
}

fun main() {
    println(solution("abacaba"))
    println(solution("abacdec"))
    println(solution("dddd"))
}



















