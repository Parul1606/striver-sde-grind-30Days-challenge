class Solution{
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++){
            int ans = target-nums[i];

            if(map.containsKey(ans)){
                return new int[] {map.get(ans),i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }
}