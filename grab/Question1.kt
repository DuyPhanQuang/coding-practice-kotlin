package grab

/* QUESTION 1
1/You are given a string of the English alphabet. You must split this string into a minimal number of substrings in such a way that no letter occurs more than once in each substring.
For example, here are some correct splits of the string "abacdec": ('a', 'bac', 'dec'), ('a', bacd', 'ec') and ('ab', 'ac', 'dec').
* */

// check whether all characters in the string are unique
fun isUnique(s: String): Boolean {
    val seen = mutableSetOf<Char>()
    // we iterate through each character in the string and check if it has been seen before
    // if we encounter a character that is already in the set, it means the string does not have all
    // unique characters, so return false
    // if we iterate through the entire string without encounter any duplicate characters, so return true.
    for (char in s) {
        if (seen.contains(char)) {
            return false
        }
        seen.add(char)
    }
    return true
}

fun splitString(s: String): List<List<String>> {
    // initialize an empty mutable list as name substrings to store the valid splits of input string
    val substrings = mutableListOf<List<String>>()
    // use bruteforce ways for running nested loop to iterate overall possible indices i and j such that i is less than j
    // these indices represent the positions where the string will be split into three substrigns
    for (i in 1 until s.length) {
        for (j in i + 1 until s.length) {
            val s1 = s.substring(0, i)
            val s2 = s.substring(i, j)
            val s3 = s.substring(j)
            // check if each of three substrings extracted above contain only unique characters
            // if all three substrings have unique characters, we consider it as a valid split and push it to the list of substrings
            val isValid = isUnique(s1) && isUnique(s2) && isUnique(s3)
            if (isValid) {
                substrings.add(listOf(s1,s2,s3))
            }
        }
    }
    return substrings
}

fun main() {
    val inputString = "abacdec"
    val result = splitString(inputString)
    result.forEach { println(it) }
}