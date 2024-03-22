package grab

/*
There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return true if you can finish all courses. Otherwise, return false.
Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take.
To take course 1 you should have finished course 0. So it is possible.
Example 2:

Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take.
To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
* */

// Break down problem into sub-problem:
// Understanding Input:
// We're given the total number of courses (numCourses) and an array prerequisites where each element [ai, bi] indicates that course bi must be taken before course ai.
// We need to understand the structure and constraints of the input data.
// Graph Representation:
// Convert the prerequisites into a graph representation.
// Choose an appropriate data structure to represent the graph.
// Ensure the graph allows easy access to prerequisite relationships.
// Detecting Cycles:
// Perform a depth-first search (DFS) traversal on the graph to detect cycles.
// Implement DFS to visit each node and explore its neighbors.
// Detect if a node is being visited during the traversal, indicating a cycle.

// Certainly. Let's break down the solution step by step:
// 1. graph representation
// the first step is to present the given prerequisites as a graph. we create adjacency list
// representation of the graph. we use an array of mutable list to represent the adjacency list.
// each index of array represent a course and the corresponding list contains the prerequisites for that course.
// 2. use dfs traversal
// the core of solution lies in performing a dfs traversal on the graph to detect cycles.
// we define a dfs function that takes a course and an array to keep track of visited nodes.
// the dfs function return true if no cycle is detected starting from the current course.
// it returns false if a cycle is found during the traversal.
// during the traversal, if we encounter a course that is currently being visited (marked as 1 in the visited array)
// it indicates a cycle then we return false.
// if a course has been visited before(marked as -1 in the visited array), it means we have already
// determined that there is no cycle starting from that course so we return true
// otherwise, we mark the course as being visited, explore its prerequisites recursively and then mark it
// as visited once the dfs traversal from that course complete.

// overall
// Main Logic:
//
// In the main function, we initialize an array to keep track of visited nodes and perform DFS traversal on each course.
// If any DFS traversal returns false, indicating the presence of a cycle, we immediately return false, indicating that it's impossible to finish all courses.
// If all DFS traversals complete without detecting any cycles, we return true, indicating that it's possible to finish all courses.

// Time complexity: O(V + E)
// Space complexity: O(V + E)
// Where V is the number of courses and E is the number of prerequisites.
fun solution(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
    // create adjacency list represent of the graph
    val graph = Array(numCourses) { mutableListOf<Int>() }
    for (pre in prerequisites) {
        graph[pre[0]].add(pre[1])

    }
    // perform dfs traversal to detect cycles
    fun dfs(course: Int, visited: Array<Int>): Boolean {
        // case: course is being visited in the current dfs traversal
        if (visited[course] == 1) {
            return false
        }
        // case: course has been visited in a previous dfs traversal
        if (visited[course] == -1) {
            return true
        }
        //mark course as being visited
        visited[course] = 1

        // explore prerequisites
        for (p in graph[course]) {
            if (!dfs(p, visited)) {
                return false
            }
        }

        // mark course as visited
        visited[course] = -1
        return true
    }

    // perform dfs traversal on each course
    val visited = Array(numCourses) { 0 }
    for (course in 0 until numCourses) {
        if (!dfs(course, visited)) {
            return false
        }
    }

    return true
}

fun main() {
    println(solution(2, arrayOf(intArrayOf(1,0))))
    println(solution(2, arrayOf(intArrayOf(1,0), intArrayOf(0,1))))
}