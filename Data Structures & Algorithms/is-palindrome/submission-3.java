class Solution {
    public boolean isPalindrome(String s) {
        int len = s.length();
        int l =0;
        int r = len-1;
        while(l<r){
            if(s.charAt(l)==' ' || !Character.isLetterOrDigit(s.charAt(l))){
                l++;
                continue;
            }
            if(s.charAt(r)==' ' || !Character.isLetterOrDigit(s.charAt(r))){
                r--;
                continue;
            }
            if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
