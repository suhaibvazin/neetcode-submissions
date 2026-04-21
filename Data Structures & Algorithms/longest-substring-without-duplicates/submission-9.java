class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int n = s.length();
        int l = 0; // Left pointer
        int r = 0; // Right pointer
        int maxLen = 0;

        // Use HashSet for O(1) lookups
        Set<Character> set = new HashSet<>();

        while (r < n) {
            char val = s.charAt(r);

            // If duplicate found, shrink window from LEFT until duplicate is removed
            if (!set.add(val)) {
                set.remove(s.charAt(l));
                l++;
            } else {
                //expand window to RIGHT
                maxLen = Math.max(maxLen, r - l + 1);
                r++;
            }
        }
        
        return maxLen;
    }
}