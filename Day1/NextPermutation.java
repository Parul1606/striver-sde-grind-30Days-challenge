class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n-2;

        //step 1: find the first decreasing element from end
        while(i >= 0 && nums[i] >= nums[i+1]){
            i--;
        }

        //step2: If found, find element just greater and swap
        if(i >= 0){
            int j = n-1;
            while(nums[j] <= nums[i]){
                j--;
            }
            // swap nums[i] and nums[j]
            swap(nums, i, j);
        }

        //step3: reverse from i+1 to end
        reverse(nums, i+1, n-1);
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int start, int end){
        while(start < end){
            swap(nums, start++, end--);
        }
    }
}