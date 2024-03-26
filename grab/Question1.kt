package grab

/* QUESTION 1
1/You are given a string of the English alphabet. You must split this string into a minimal number of substrings in such a way that no letter occurs more than once in each substring.
For example, here are some correct splits of the string "abacdec": ('a', 'bac', 'dec'), ('a', bacd', 'ec') and ('ab', 'ac', 'dec').
* */

// question type: Find minimum number of Substrings with unique characters

// certainly, let's break down solution step by step:
// we initialize an empty hashset to store unique characters and iterate through the given string
// for each character encountered, we check if it's already present in the set
// if it's, it means that we need to start new a substring since the current substring has repeated
// character.
// we increase our answer variable and clear the set to start a new substring
// then we add the current character to the set.
// after iterating through the entire string, the value of answer variable give us the minimum number
// of substrings required to partition the given string such that each substring has unique characters.

// Time Complexity: O(n) where n is the length of the input string.
// Auxiliary Space: O(n) in the worst case
// This is because we store each character of the input string in the hash set,
// and in the worst case, all characters of the string are unique.
private fun solution(s: String): Int {
    val uniqueCharacters = hashSetOf<Char>()
    var ans = 1
    for (i in s.indices) {
        // Check if the current character is already present in the set
        if (uniqueCharacters.contains(s[i])) {
            // If it is, increment the answer variable
            // and clear the set to start a new substring
            ans++
            uniqueCharacters.clear()
        }
        // Add the current character to the set
        uniqueCharacters.add(s[i])
    }
    // Return the answer variable, which gives the
    // minimum number of substrings required
    return ans
}

fun main() {
    println(solution("abacaba"))
    println(solution("abacdec"))
    println(solution("dddd"))
}














