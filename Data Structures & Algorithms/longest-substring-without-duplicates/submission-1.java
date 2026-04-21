class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        int l =0;
        int r = 0;
        int count =0;
        Set<Character> uniqueSet = new HashSet<>();
        while(r<len){
            if(!uniqueSet.add(s.charAt(r))){
                uniqueSet.remove(s.charAt(l));
                l++;
            }else{
                count = Math.max(count,r-l+1);
                r++;
            }

  
        }

        return count;
        
    }
}