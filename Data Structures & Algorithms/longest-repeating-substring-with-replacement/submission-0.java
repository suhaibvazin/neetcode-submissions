class Solution {
    public int characterReplacement(String s, int k) {
        int [] freq = new int[26];
        int maxC = 0;
        int ans = 0;

        int l=0;
        for(int r =0; r<s.length(); r++){
            char c = s.charAt(r);
            freq[c-'A']++;
            maxC = Math.max(freq[c-'A'],maxC);

            if(r-l+1-maxC > k){
                freq[s.charAt(l)-'A']--;
                l++;
            }
            ans = Math.max(r-l+1,ans);
        }
        return ans;
        
    }
}
