class Solution {
    public void sortColors(int[] nums) {
        int low = 0;        // For 0s
        int mid = 0;        // For current element
        int high = nums.length - 1; // For 2s

        while (mid <= high) {
            if (nums[mid] == 0) {
                // Swap nums[low] and nums[mid]
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++; // 1 is in correct place
            } else {
                // nums[mid] == 2 → swap with high
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;
                high--;
            }
        }
    }
}