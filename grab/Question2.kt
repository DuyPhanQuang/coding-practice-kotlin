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

/**
 * the main logic of this solution revolves around using dynamic programming
 * to find the minimum number of substrings need to cover the given string.
 * - Certainly, break down the solution step by step:
 * 1. we initialize an int array has size n + 1 where n is the length of given string.
 * this array will store the minimum number of substrings need to cover each prefix of the string
 * 2. we set an array at indices:0 = 0 to indicate that no splits are need to cover empty prefix
 * 3. approach way for iteration: we running nested loop.
 * outer loop we iterate over each position i starting from 1 to the length of given string
 * inner loop we iterate all possible starting position j from 0 to i -1.
 * outer loop: at each position i we aim to find minimum number of substrings need to cover the prefix
 * ending at position i.
 * inner loop: this represent all possible substrings endings at position i,
 * for each substrings from j to i, we should check if it contains unique characters via
 * comparing the lengths of substrings and the set.
 * if the lengths are equal it means all characters are unique then we update an array at position i
 */

/**
 * time complexity: 0(n^2)
 * space complexity: 0(n)
* */

fun solution(s: String): Int {
    val dp = IntArray(s.length + 1)
    for (i in 1..s.length) {
        dp[i] = i
        for (j in 0 until i) {
            val substrings = s.substring(j,i)
            // dp[j+1] represent minimum number of substrings need to cover prefix of ending
            // at position j, plus one more substring for the current substrings from j to i
            if (substrings.toSet().size == substrings.length) {
                dp[i] = minOf(dp[i], dp[j]+1)
            }
        }
    }

    return dp[s.length]
}

fun main() {
    println(solution("world"))
    println(solution("dddd"))
    println(solution("cycle"))
    println(solution("abba"))
}