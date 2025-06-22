class Solution {
    public List<Integer> majorityElement(int[] nums) {
        // Step 1: Initialize two potential majority candidates and their counts
        Integer majority1 = 0;
        Integer majority2 = 0;
        int count1 = 0;
        int count2 = 0;

        // Step 2: First pass - Boyer-Moore Voting Algorithm extension
        for (int num : nums) {
            if (num == majority1) {
                count1++; // If current number matches candidate 1, increment its count
            } else if (num == majority2) {
                count2++; // If current number matches candidate 2, increment its count
            } else if (count1 == 0) {
                majority1 = num; // If count1 is 0, assign new candidate
                count1 = 1;
            } else if (count2 == 0) {
                majority2 = num; // If count2 is 0, assign new candidate
                count2 = 1;
            } else {
                // If current number doesn't match either candidate, reduce both counts
                count1--;
                count2--;
            }
        }

        // Step 3: Second pass - count actual occurrences of the potential candidates
        count1 = 0;
        count2 = 0;

        for (int num : nums) {
            if (num == majority1) {
                count1++;
            } else if (num == majority2) {
                count2++;
            }
        }

        // Step 4: Prepare the result list with validated candidates
        List<Integer> res = new ArrayList<>();
        int n = nums.length;

        // Add majority1 to result if its count > ⌊n/3⌋
        if (count1 > n / 3) {
            res.add(majority1);
        }

        // Add majority2 to result if its count > ⌊n/3⌋
        if (count2 > n / 3) {
            res.add(majority2);
        }

        // Step 5: Return the list of majority elements
        return res;
    }
}
