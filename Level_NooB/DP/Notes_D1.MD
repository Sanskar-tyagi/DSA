@@ -0,0 +1,51 @@

## RECURSION

- overlapping subproblems - smaller versions of the original problem that are re-used multiple times.

## Memoization

- Memory wastage

1.  **memoizing** a result means to store the result of a function call, usually in a hashmap or an array, so that when the same function call is made again, we can simply return the **memoized** result instead of recalculating the result.
2.  Memoization involves storing the result of a function call in a hashmap or an array, so that the same function call can be returned with the memoized result instead of recalculating the result.

- Memoization helps to avoid unnecessary calculations and memory wastage.

## TABULATION

- DOS ->DIRECTION OF SOL

  To get to the tabulation version of the DP we need to go thru the process.

  1. The process of Firstly solving a problem with Recurrsive approach.
  2. Identifying Overlapping subproblems that can be either memorized or utilzied saving the space and time exponentialy.
  3. After finding the overlapping subproblems we try to save them using an array or hashmap.
  4. But this method is costly as we still require extra space.
  5. So we find the Direction of Solution in the tree it is being created.
  6. once we identify that we use tabulation method to further save space.

- Tabulation involves solving a problem by iterating over all subproblems and storing the results of each subproblem in a table or array.
- In tabulation, we start with the base cases and work our way up to the final solution by computing the values for all subproblems.

## OPTIMIZED TABULATION

- Optimized tabulation is a more efficient version of tabulation that reduces the space complexity by using an equation to compute the result of each subproblem instead of storing all subproblems in a table or array.
- This method saves space by not storing all subproblems, and instead only storing the necessary values needed to compute the next subproblem.

## Comman Nature Of DP

**The first characteristic** that is common in DP problems is that the problem will ask for the optimum value (maximum or minimum) of something, or the number of ways there are to do something. For example:

- What is the minimum cost of doing...
- What is the maximum profit from...
- How many ways are there to do...
- What is the longest possible...
- Is it possible to reach a certain point...

> **Note:** Not all DP problems follow this format, and not all problems that follow these formats should be solved using DP. However, these formats are very common for DP problems and are generally a hint that you should consider using dynamic programming.

The next characteristic will help us determine whether a problem should be solved using a greedy algorithm or dynamic programming.

**The second characteristic** that is common in DP problems is that future "decisions" depend on earlier decisions. Deciding to do something at one step may affect the ability to do something in a later step. This characteristic is what makes a greedy algorithm invalid for a DP problem - we need to factor in results from previous decisions.

To summarize: if a problem is asking for the maximum/minimum/longest/shortest of something, the number of ways to do something, or if it is possible to reach a certain point, it is probably greedy or DP. With time and practice, it will become easier to identify which is the better approach for a given problem. Although, in general, if the problem has constraints that cause decisions to affect other decisions, such as using one element prevents the usage of other elements, then we should consider using dynamic programming to solve the problem. **These two characteristics can be used to identify if a problem should be solved with DP.**
