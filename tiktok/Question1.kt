package tiktok
/***
idea
the problem requires determining the total number of ways to decode a given string of digits according to a specific mapping.
each digit can represent either a single character or be combined with the previous digit to represent a character.
the mapping assigns each letter from 'a' to 'z' corresponding number from 1 to 26.

approach
we use dynamic programming to solve the problem efficiently.
firstly we initialize an array dp of size n+1 where n is the length of the input string. dp[i] represent the total number of way to decode the substrings s[0:i]
initialize dp[0]=1 and dp[1]=1 if the first digit of given input string is not '0'
 then we iterate through the given input string starting from index 2.
 we check if the current digit alone can de decoded(eg. it's not '0') if so add dp[i-1] to dp[i]
 we check if the current and previous digits together can be decoded as a valid character(eg. the two digit number falls within range 10 to 26)
 if so  add dp[i-2] to dp[i]. finally, we return dp[n] where n is the length of input string this represents the total number of ways to decode the entire input string.

complexity
time: 0(n)
space: 0(n) because we use additional array dp of size n+1 to store the number of decoding ways for substring of the given input.
***/

private fun solution(s: String): Int {
    if (s.isEmpty()) return 0
    val n = s.length
    val dp = IntArray(n + 1)
    dp[0] = 1
    dp[1] = if (s[0] != '0') 1 else 0
    for (i in 2..n) {
        if (s[i - 1] != '0') {
            dp[i] += dp[i - 1]
        }
        val twoDigits = s.substring(i - 2, i).toInt()
        if (twoDigits in 10..26) {
            dp[i] += dp[i - 2]
        }
    }
    return dp[n]
}

fun main() {
    println(solution("123"))
    println(solution("926"))
    println(solution("927"))
    println(solution("999"))
    println(solution("269"))
    println(solution("279"))
    println(solution("021"))
}