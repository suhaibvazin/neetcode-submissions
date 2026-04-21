class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0 || s.length() < t.length()) {
            return "";
        }

        // Use size 128 to cover all standard ASCII characters (both upper and lower case)
        int[] tArray = new int[128];
        int requiredUniqueChars = 0;
        
        for(char c : t.toCharArray()){
           if(tArray[c]==0){
            requiredUniqueChars++;
           }
           tArray[c]++; 
        }
        int[] sArray = new int[128];
        int leftMost=0;
        int minLen = Integer.MAX_VALUE;
        int l = 0;
        int currentUniqueChars = 0;
        for(int r =0; r < s.length();r++){
            char c = s.charAt(r);
            sArray[c]++;
            if(tArray[c] > 0 && sArray[c] == tArray[c]){
                currentUniqueChars++;
            }
            while(l<=r && requiredUniqueChars==currentUniqueChars){
                if(r-l+1 < minLen){
                    minLen = r-l+1;
                    leftMost= l;
                }
                char leftChar = s.charAt(l);
                sArray[leftChar]--;
                if(tArray[leftChar] > 0 && sArray[leftChar] < tArray[leftChar]){
                    currentUniqueChars--;
                }
                l++;
            }
        }
        return minLen==Integer.MAX_VALUE?"":s.substring(leftMost,minLen+leftMost);

    }
}