class Solution {
    public boolean isAnagram(String s, String t) {

        if(s.length() != t.length()){
            return false;
        }
        int [] sArray = new int[26];
        int [] tArray = new int[26];

        int len = s.length();

        for(int i=0; i<len ;i++){
            sArray[s.charAt(i)-'a']++;
            tArray[t.charAt(i)-'a']++;
        }

        return Arrays.equals(sArray,tArray);
    }
}
