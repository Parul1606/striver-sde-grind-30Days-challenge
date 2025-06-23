class Solution {
    public int longestConsecutive(int[] nums) {
        // optimized approach to solve this problem is using set as it wont store duplicates
        int n = nums.length;

        if(nums.length == 0){
            return 0;
        }

        int longest = 1;
        HashSet<Integer> set = new HashSet<>();

        for(int i=0; i<n; i++){
            set.add(nums[i]);
        }

        for(int num : set){
            if(!set.contains(num-1)){
                int curr = 1;
                int x = num;
                while (set.contains(x + 1)) {
                    curr++;
                    x++;
                }
                longest = Math.max(curr, longest);
            }


        }

        return longest;
    }
}

/**
 class Solution {
 // This is not an optimal approach becuase it takes O(nlogn) tc which is not efficient
 public int longestConsecutive(int[] nums) {
 Arrays.sort(nums);

 if(nums.length == 0){
 return 0;
 }
 int longest = 1;
 int count = 0;
 int lastNum = Integer.MIN_VALUE;

 for(int num : nums){
 if(num-1 == lastNum){
 count++;
 lastNum = num;
 } else if(num != lastNum){
 count = 1;
 lastNum = num;
 }
 longest = Math.max(longest, count);
 }
 return longest;
 }
 }
 */