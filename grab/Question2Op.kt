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
/** idea:
 * we create a hashset to store characters that we have encountered so far in the current substring
 * whenever we encounter a character that is already present in the current substrings,
 * we increment the count of substrings and reset a hashset for the next substring.
 * **/

/** break down solution step by step:
 * We maintain a HashSet named `seen` to keep track of characters encountered so far in the current substring.
 * We iterate through each character in the string s. For each character:
 * If the character is not present in the HashSet, we add it to the HashSet and append it to the current substring.
 * If the character is already present in the HashSet, it means we have encountered a duplicate character,
 * and we increment the count of substrings then we clear the HashSet,
 * add the current character to it, and reset the current substring to the current character.
 * Finally, we return the count + 1 to account for the last substring,
 * as we are counting the number of times we encounter duplicate characters.
 **/

/**
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * Time Complexity: the time complexity of the solution is O(n), where n is the length of the input string.
 * Iterating Through Characters: We iterate through each character in the string exactly once.
 * This operation takes O(n) time, where n is the length of the input string.
 * HashSet Operations: For each character, we perform operations like checking if
 * the character is present in the HashSet, adding the character to the HashSet,
 * and clearing the HashSet when encountering duplicate characters.
 * These operations take constant time on average,so they don't significantly affect the overall time complexity.
 * Space Complexity: the space complexity of the solution is O(n), where n is the length of the input string.
 * HashSet: We use a HashSet to store unique characters encountered so far in the current substring.
 * The space complexity of a HashSet is proportional to the number of unique elements it contains.
 * In the worst case, if all characters in the string are unique, the HashSet will contain all characters,
 * resulting in a space complexity of O(n), where n is the length of the input string.
 * Additional Variables: We use a few additional variables like count and temporary variables
 * to store characters or substrings, which require constant space.
 * **/

private fun solution(s: String): Int {
    val seen = hashSetOf<Char>()
    var count = 0
    var substring = ""
    for (char in s) {
        if (char !in seen) {
            seen.add(char)
            substring += char
        } else {
            count++
            seen.clear()
            seen.add(char)
            substring = char.toString()
        }
    }
    return count + 1
}

fun main() {
    println(solution("world"))
    println(solution("dddd"))
    println(solution("cycle"))
    println(solution("abba"))
}














