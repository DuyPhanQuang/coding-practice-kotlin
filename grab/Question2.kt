package grab

/* QUESTION 2
Write a function:
class Solution { public int solution(String S); }
that, given a string S of length N, returns the minimum number of substrings into which the string has to be split.
Examples:
1. Given 'world', your function should return 1. There is no need to split the string into substrings as all letters occur just once.
2. Given 'dddd', your function should return 4. The result can be achieved by splitting the string into four substrings ('d', 'd', 'd', 'd').
3. Given 'cycle', your function should return 2. The result can be achieved by splitting the string into two substrings ('cy', 'cle') or ('c', 'ycle').
4. Given 'abba', your function should return 2. The result can be achieved by splitting the string into two substrings ('ab', 'ba').
 */

fun solution(s: String): Int {
    // Initialize to maximum possible splits has size s.length + 1
    // this arr will store the minimum number of substrings need to cover each prefix of s
    val dp = IntArray(s.length + 1)
    // we iterate over each position i in the string s, starting from index = 1.
    // at each position i, we aim to find the minimum number of substrings need to cover prefix ending at position i
    // we running nested loop for each position i, we iterate over all possible starting position j (from 0 to i-1)
    // this represent all possible substrings ending at position i.
    for (i in 1..s.length) {
        dp[i] = i
        for (j in 0 until i) {
            val substring = s.substring(j, i)
            // check if it contains unique characters.
            // converting the substring to a set then comparing the length of set and the substring.
            // if the length are equal, it means all characters in the substring are unique.
            if (substring.toSet().size == substring.length) {
                // we update dp[i] to be the minimum of its current value and dp[j]+1.
                // dp[j]+1 represent the minimum number of substrings need to cover the prefix ending at position j
                // plus one more substring for the current substring from j to i
                dp[i] = minOf(dp[i], dp[j] + 1)
            }
        }
    }

    // dp[s.length] represent the minimum number of substrings need to cover the entire input string.
    return dp[s.length]
}

fun main() {
    println(solution("world"))
    println(solution("dddd"))
    println(solution("cycle"))
    println(solution("abba"))
}