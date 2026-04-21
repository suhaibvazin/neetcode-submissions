class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length()) return false;
        int maxLen = s1.length();

        int [] truth = new int[26];
        int [] current = new int[26];

        for(int i=0; i<s1.length(); i++){
            truth[s1.charAt(i)-'a']++;
            current[s2.charAt(i)-'a']++;
        }

        //check current window
        if(Arrays.equals(current,truth)){
            return true;
        }

        int l=0;

        for(int r=maxLen; r<s2.length(); r++){
            current[s2.charAt(r)-'a']++;
            current[s2.charAt(l)-'a']--;
            l++;
        if(Arrays.equals(current,truth)){
            return true;
        }
        }
        return false;
    }
}


