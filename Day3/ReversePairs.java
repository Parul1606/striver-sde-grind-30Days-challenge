class Solution {
    public int reversePairs(int[] nums) {
        // Start the modified merge sort that also counts reverse pairs
        return mergeSort(nums, 0, nums.length - 1);
    }

    // Merge sort function that returns count of reverse pairs
    private int mergeSort(int[] nums, int left, int right) {
        // Base case: single element, no reverse pair
        if (left >= right) return 0;

        int mid = (left + right) / 2;

        // Count reverse pairs in left and right halves
        int count = mergeSort(nums, left, mid) + mergeSort(nums, mid + 1, right);

        // Count cross reverse pairs where left element > 2 * right element
        int j = mid + 1;
        for (int i = left; i <= mid; i++) {
            while (j <= right && (long) nums[i] > 2L * nums[j]) {
                j++;  // Move j forward as long as condition holds
            }
            count += j - (mid + 1); // j - (mid + 1) elements form reverse pairs with i
        }

        // Merge the two sorted halves
        merge(nums, left, mid, right);

        return count;
    }

    // Standard merge function to merge two sorted subarrays
    private void merge(int[] nums, int left, int mid, int right) {
        List<Integer> temp = new ArrayList<>();
        int i = left, j = mid + 1;

        // Merge two sorted halves into a temp list
        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                temp.add(nums[i++]); // Left element is smaller or equal
            } else {
                temp.add(nums[j++]); // Right element is smaller
            }
        }

        // Add remaining elements from left half (if any)
        while (i <= mid) temp.add(nums[i++]);

        // Add remaining elements from right half (if any)
        while (j <= right) temp.add(nums[j++]);

        // Copy sorted temp back into original nums array
        for (int k = 0; k < temp.size(); k++) {
            nums[left + k] = temp.get(k);
        }
    }
}
