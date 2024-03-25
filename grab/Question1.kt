package grab

/* QUESTION 1
1/You are given a string of the English alphabet. You must split this string into a minimal number of substrings in such a way that no letter occurs more than once in each substring.
For example, here are some correct splits of the string "abacdec": ('a', 'bac', 'dec'), ('a', bacd', 'ec') and ('ab', 'ac', 'dec').
* */

// the main logic is revolve around generating all possible splits of the input string into three substrings,
// ensure that each substrings contains only unique characters.

// Certainly, let break down solution step by step:
// - nested loops for splitting: running nested loops to iterate over all possible pairs of indices(i,j)
// where i and j represent the positions where the string will be split into three substrings.
// the outer loop iterate over the starting index i and the inner loop iterate over the ending index j
// these loops generate all possible splits of the input string
// - extracting substrings: for each pair indices(i,j), three substrings are extract from the input string
// these substrings represent three parts obtained after splitting the string at position i,j
// - checking substring unique: check if each of three substrings contains only unique characters.
// this function iterate through the characters of the substring and maintains a set of characters seen so far.
// if it encounter a character that is already in the set, if return false indicating that the substring
// does not have all unique characters.
// - adding valid splits: if all  three substrings have unique characters, the current splits is considered valid,
// and the three substrings are added to the list of valid splits.

// time complexity: overall, is dominated by the nested loop,
// is approximately 0(n^2) where n is the length of input
// space complexity: is 0(n^2) where n is the length of input

// check whether all characters in the string are unique
fun isUnique(s: String): Boolean {
    val seen = mutableSetOf<Char>()
    for (char in s) {
        if (seen.contains(char)) {
            return false
        }
        seen.add(char)
    }
    return true
}

fun splitString(s: String): List<List<String>> {
    val substrings = mutableListOf<List<String>>()
    for (i in 1 until s.length) {
        for (j in i + 1 until s.length) {
            val s1 = s.substring(0, i)
            val s2 = s.substring(i, j)
            val s3 = s.substring(j)
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