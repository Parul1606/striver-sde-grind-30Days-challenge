class Solution {
    public int longestSubarray(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        int sum = 0;
        int maxL = 0;

        for(int i=0; i<nums.length; i++){
            sum += nums[i];

            if(sum == k){
                maxL = i+1;
            }

            if(map.containsKey(sum-k)){
                int prevIndex = map.get(sum-k);
                maxL = Math.max(maxL, i-prevIndex);
            }

            if(!map.containsKey(sum)){
                map.put(sum,i);
            }
        }

        return maxL;
    }
}