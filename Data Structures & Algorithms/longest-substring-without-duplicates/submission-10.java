class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int n = s.length();
        int l = 0;
        int r = 0; 
        int maxLen = 0;

        Set<Character> set = new HashSet<>();

        while (r < n) {
            char val = s.charAt(r);

        
            if (!set.add(val)) {
                set.remove(s.charAt(l));
                l++;
            } else {
                maxLen = Math.max(maxLen, r - l + 1);
                r++;
            }
        }
        
        return maxLen;
    }
}