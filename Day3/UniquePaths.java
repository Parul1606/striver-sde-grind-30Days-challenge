class Solution {
    public int uniquePaths(int m, int n) {
        /**
         Why Combinatorics?
         Because:

         In recursion → you explore all paths

         But that leads to TLE for large m and n (like 100x100)

         So instead, we use math to directly calculate the number of such paths.
         */


        // We use long to avoid overflow since intermediate values can get large
        long ans = 1;

        // Total number of moves = (m-1) down + (n-1) right = (m + n - 2)
        int total = m + n - 2;

        // We need to choose (m-1) down moves (or (n-1) right moves) from the total moves
        // So we calculate: C(total, m-1) = total! / ((m-1)! * (n-1)!)
        // We use the smaller of (m-1) and (n-1) to minimize loop iterations
        int r = Math.min(m - 1, n - 1);

        // Loop to compute combination using iterative multiplication
        // C(total, r) = (total * (total - 1) * ... * (total - r + 1)) / (r!)
        for (int i = 1; i <= r; i++) {
            // Multiply numerator and divide denominator at each step to avoid overflow
            ans = ans * (total - r + i) / i;
        }

        // Since we only return an integer number of paths, we cast the result to int
        return (int) ans;
    }
}

/*
class Solution {
    // this is recursion which exceeds time limit
    public int uniquePaths(int m, int n) {
        return countPaths(0, 0, m, n);
    }

    private int countPaths(int i, int j, int m, int n){
        if(i>=m || j >= n) return 0;

        if(i == m-1 && j == n-1) return 1;

        return countPaths(i+1, j, m, n) + countPaths(i, j+1, m, n);
    }
}

 1. Base case:
 1. if i>=m, j>=n -> return 0;  .... out of bounds
 2. if i=m-1 && j=n-1 -> return 1; .... destination reached

 2. if arr[i][j] = 0,0 -> then it has 2 options
 1. either move to 0,1
 2. or move to 1,0

 3. Recursion helps in breaking the problem into subproblems from current cell to destination
 So, we will solve it Recursively to explore all valid paths to reach bottom-right

 */