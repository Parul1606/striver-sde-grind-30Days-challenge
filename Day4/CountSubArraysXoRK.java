class Solution {
    public int subarraysWithXorK(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int xor = 0;

        map.put(0, 1); // To handle subarrays starting from index 0

        for (int num : nums) {
            xor ^= num; // running xor

            // Check if there is a prefix with xor = xor ^ k
            int required = xor ^ k;

            if (map.containsKey(required)) {
                count += map.get(required);
            }

            // Update the map with current xor frequency
            map.put(xor, map.getOrDefault(xor, 0) + 1);
        }

        return count;
    }
}
