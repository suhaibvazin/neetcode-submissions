// class Solution {
//     public boolean checkInclusion(String s1, String s2) {
//         int maxLen = s1.length();

//         int [] truth = new int[26];
//         int [] current = new int[26];

//         for(int i=0; i<s1.length(); i++){
//             truth[s1.charAt(i)-'a']++;
//             current[s2.charAt(i)-'a']++;
//         }

//         //check current window
//         if(Arrays.equals(current,truth)){
//             return true;
//         }

//         int l=0;

//         for(int r=maxLen; r<s2.length(); r++){
//             current[s2.charAt(r)-'a']++;
//             current[s2.charAt(l)-'a']--;
//             l++;
//         if(Arrays.equals(current,truth)){
//             return true;
//         }
//         }
//         return false;
//     }
// }

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        
        // Instead of a single sum, we use arrays to count character frequencies
        int[] s1Count = new int[26];
        int[] windowCount = new int[26];
        
        // Populate the initial frequencies for s1 and the first window of s2
        for (int i = 0; i < s1.length(); i++) {
            s1Count[s1.charAt(i) - 'a']++;
            windowCount[s2.charAt(i) - 'a']++;
        }
        
        // Check the very first window
        if (Arrays.equals(s1Count, windowCount)) return true;
        
        // Slide the window across the rest of s2
        int l = 0;
        for (int r = s1.length(); r < s2.length(); r++) {
            // Add the new character entering the window from the right
            windowCount[s2.charAt(r) - 'a']++;
            
            // Remove the old character leaving the window from the left
            windowCount[s2.charAt(l) - 'a']--;
            l++; // shrink window
            
            // If the frequency arrays match perfectly, we found a permutation!
            if (Arrays.equals(s1Count, windowCount)) {
                return true;
            }
        }
        
        return false;
    }
}
