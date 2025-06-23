class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums); // Step 1: Sort the array

        List<List<Integer>> result = new ArrayList<>();

        // First pointer i
        for (int i = 0; i < n - 3; i++) {
            // Skip duplicate i
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            // Second pointer j
            for (int j = i + 1; j < n - 2; j++) {
                // Skip duplicate j
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                int left = j + 1;
                int right = n - 1;

                // Two pointers for remaining pair
                while (left < right) {
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];

                    if (sum == target) {
                        // Add the valid quadruplet
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));

                        // Skip duplicates for left
                        while (left < right && nums[left] == nums[left + 1]) left++;

                        // Skip duplicates for right
                        while (left < right && nums[right] == nums[right - 1]) right--;

                        // Move both pointers
                        left++;
                        right--;
                    } else if (sum < target) {
                        left++; // Increase sum
                    } else {
                        right--; // Decrease sum
                    }
                }
            }
        }

        return result;
    }
}
