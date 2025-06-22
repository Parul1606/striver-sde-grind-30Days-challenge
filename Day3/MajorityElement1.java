// OPTIMIZED SOLUTION
// Boyer-Moore algorithm efficiently finds a majority element (if it exists) by canceling out different elements using a count variable.
// It works in O(n) time and O(1) space, making it optimal for detecting elements appearing more than n/2 times.

class Solution {
    public int majorityElement(int[] nums) {
        // Step 1: Initialize count and candidate
        int count = 0;
        int candidate = 0;

        // Phase 1: Finding a potential candidate using Boyer-Moore Voting
        for (int num : nums) {
            if (count == 0) {
                // If no current candidate, choose the current number
                candidate = num;
                count = 1;
            } else if (num == candidate) {
                // Same as candidate → increase support
                count++;
            } else {
                // Different from candidate → cancel one vote
                count--;
            }
        }

        // Phase 2: Verifying if the chosen candidate is actually majority
        count = 0; // Reset count
        for (int num : nums) {
            if (num == candidate) {
                count++; // Count how many times candidate actually occurs
            }
        }

        // If candidate appears more than n/2 times, return it; else return -1
        return (count > nums.length / 2) ? candidate : -1;
    }
}

/* THIS SOLUTION TAKES O(N) time and O(N) space
class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;            // Length of input array
        int maxE = -1;                  // To store element with highest frequency (potential majority)
        int maxC = 0;                   // To store highest frequency count

        HashMap<Integer, Integer> map = new HashMap<>(); // Stores frequency of each element

        // Traverse array to count frequencies
        for(int num : nums){
            int freq = map.getOrDefault(num, 0) + 1; // Increment frequency
            map.put(num, freq);                      // Update in map

            // Keep track of element with highest frequency
            if(freq > maxC){
                maxC = freq;
                maxE = num;
            }
        }

        // If highest frequency > n/2 → return as majority element
        if(maxC > n/2){
            return maxE;
        } else{
            return -1; // No majority element exists
        }
    }
}

*/
