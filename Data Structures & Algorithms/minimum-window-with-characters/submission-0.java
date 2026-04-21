class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0 || s.length() < t.length()) {
            return "";
        }

        // Use size 128 to cover all standard ASCII characters (both upper and lower case)
        int[] tArray = new int[128];
        int requiredUniqueChars = 0;
        
        // Populate the frequency array for string t
        for (char ch : t.toCharArray()) {
            if (tArray[ch] == 0) {
                requiredUniqueChars++;
            }
            tArray[ch]++;
        }

        int[] sArray = new int[128];
        int l = 0, r = 0;
        int formedChars = 0; // Tracks how many unique chars from t are fully matched in the window

        // Variables to keep track of the minimum window
        int minLen = Integer.MAX_VALUE;
        int minLeft = 0; // Better to store indices and do substring once at the very end

        while (r < s.length()) {
            char c = s.charAt(r);
            sArray[c]++;

            // If the current character's frequency matches the required frequency, increment formed
            if (tArray[c] > 0 && sArray[c] == tArray[c]) {
                formedChars++;
            }

            // Shrink the window from the left as long as it is valid
            while (l <= r && formedChars == requiredUniqueChars) {
                char leftChar = s.charAt(l);
                
                // Update the minimum window size and start index
                if (r - l + 1 < minLen) {
                    minLen = r - l + 1;
                    minLeft = l;
                }

                // Remove the leftmost character from the window
                sArray[leftChar]--;
                
                // If removing this character breaks our valid window, decrement formed
                if (tArray[leftChar] > 0 && sArray[leftChar] < tArray[leftChar]) {
                    formedChars--;
                }
                
                l++; // Slide the left pointer forward
            }
            
            r++; // Slide the right pointer forward
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minLen);
    }
}