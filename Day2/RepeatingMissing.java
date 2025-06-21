class Solution {
    public int[] findMissingRepeatingNumbers(int[] nums) {
        int n = nums.length;

        // Expected sum of 1 to n (without any duplication/missing)
        long sum = (long) n * (n + 1) / 2;

        // Expected sum of squares of 1 to n
        long sumSq = (long) n * (n + 1) * (2L * n + 1) / 6;

        long actualSum = 0, actualSqSum = 0;

        // Calculating the actual sum and actual square sum from the given array
        for (int num : nums) {
            actualSum += num;
            actualSqSum += (long) num * num;
        }

        // Let repeating = A, missing = B
        // diff = A - B
        long diff = actualSum - sum;

        // sqDiff = A^2 - B^2 = (A - B)(A + B)
        long sqDiff = actualSqSum - sumSq;

        // From above: (A + B) = sqDiff / diff
        long sumAB = sqDiff / diff;

        // Solving:
        // A = (diff + sumAB) / 2
        long A = (diff + sumAB) / 2;

        // B = A - diff
        long B = A - diff;

        // Returning result as [repeating number, missing number]
        return new int[] {(int) A, (int) B};
    }
}
