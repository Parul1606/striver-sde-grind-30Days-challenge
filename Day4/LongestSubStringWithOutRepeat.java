class Solution {
    public int lengthOfLongestSubstring(String s) {

        int left = 0, right = 0; // Two pointers for sliding window
        Set<Character> seen = new HashSet<>(); // HashSet to store unique characters in current window
        int max = 0; // Variable to keep track of the max length found

        // Start traversing the string with the right pointer
        while (right < s.length()) {
            char c = s.charAt(right); // Get the current character at 'right'

            // If character not seen before in current window
            if (seen.add(c)) {
                // Update max length if current window is longer
                max = Math.max(max, right - left + 1);
                right++; // Expand the window by moving right pointer
            } else {
                // If duplicate character is found

                // Shrink the window from the left until the duplicate is removed
                while (s.charAt(left) != c) {
                    seen.remove(s.charAt(left)); // Remove characters from the left side
                    left++; // Move the left pointer ahead
                }

                // Remove the duplicate character itself and move left pointer
                seen.remove(c);
                left++;
            }
        }

        return max; // Return the maximum length of unique-character substring found
    }
}
