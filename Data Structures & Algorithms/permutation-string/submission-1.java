class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int maxLen = s1.length();

        int [] truth = new int[26];
        int [] current = new int[26];

        for(int i=0; i<s1.length(); i++){
            truth[s1.charAt(i)-'a']++;
        }

        int l=0;

        for(int r=0; r<s2.length(); r++){
            current[s2.charAt(r)-'a']++;
            if(r-l+1 > maxLen){
                current[s2.charAt(l)-'a']--;
                l++;
            }
            if(r-l+1 == maxLen){
                if(Arrays.equals(current,truth)){
                    return true;
                }
            }

        }
        return false;
    }
}
