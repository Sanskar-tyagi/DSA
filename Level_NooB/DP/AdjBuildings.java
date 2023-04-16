package DP;

public class AdjBuildings {
    // 1. You are given a number n, which represents the length of a road. The road
    // has n plots on it's each side.
    // 2. The road is to be so planned that there should not be consecutive
    // buildings on either side of the road.
    // 3. You are required to find and print the number of ways in which the
    // buildings can be built on both side of roads.
    // ! https://nados.io/question/arrange-buildings

    static int getBuildings(int n) {
        int dp[][] = new int[2][n + 1];

        // the DP in this question is to determine what are the number of possible ways
        // we can create buildings on the path such that no 2 buildings are adjacent
        // we can make a such path of N length of Building (0) nd Empty area (1) without
        // adjacent 00.
        // first step we create a storage of 0 1 cross n+1 where a cell [0/1][x] means
        // how many possible ways we can create the such strings following the above
        // rule
        // at instance dp[0/1][1] number of possible ways would be 1; Point -- 1
        // To create further new strings at ith we will use the previous values
        // Point --2
        // at instance dp[0][i]=dp[1][i-1]
        // at instance dp[1][i]=dp[1][i-1]+dp[0][i-1];
        // To prove above Point --1
        // lets say we have 1 length as N
        // so the possible way to create is 0 alone and 1 alone
        return dp[0][n + 1] + dp[1][n + 1];
    }

    public static void main(String[] args) {
        System.out.println(getBuildings(2));
    }
}
