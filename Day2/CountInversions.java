class Solution {
    public long numberOfInversions(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    // Recursive merge sort function that returns inversion count
    private long mergeSort(int[] nums, int left, int right) {
        long invCount = 0;

        if (left < right) {
            int mid = (left + right) / 2;

            // Count inversions in left half
            invCount += mergeSort(nums, left, mid);

            // Count inversions in right half
            invCount += mergeSort(nums, mid + 1, right);

            // Count inversions while merging the two halves
            invCount += merge(nums, left, mid, right);
        }

        return invCount;
    }

    // Merge function that counts inversions while merging two sorted halves
    private long merge(int[] nums, int left, int mid, int right) {
        // Temporary array to store merged result
        int[] temp = new int[right - left + 1];
        int i = left;      // Pointer for left half
        int j = mid + 1;   // Pointer for right half
        int k = 0;         // Pointer for temp array
        long invCount = 0;

        // Merge left and right halves
        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                // No inversion, add element from left side
                temp[k++] = nums[i++];
            } else {
                // Inversion found: nums[i] > nums[j] and i < j
                temp[k++] = nums[j++];
                invCount += (mid - i + 1); // All remaining elements in left half are > nums[j]
            }
        }

        // Copy remaining elements from left half, if any
        while (i <= mid) {
            temp[k++] = nums[i++];
        }

        // Copy remaining elements from right half, if any
        while (j <= right) {
            temp[k++] = nums[j++];
        }

        // Copy merged elements back to original array
        for (int l = 0; l < temp.length; l++) {
            nums[left + l] = temp[l];
        }

        return invCount;
    }
}
