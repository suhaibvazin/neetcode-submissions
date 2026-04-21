class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

       int [] small = nums1.length <= nums2.length ? nums1 : nums2; 

       int [] big = nums1.length <= nums2.length ? nums2 : nums1; 

        int lp = 0;
        int rp = small.length;

        while(lp<=rp){
            int xPos = lp + (rp-lp)/2;
            int yPos = (nums1.length + nums2.length + 1) / 2 - xPos;

            int l1 = xPos == 0 ? Integer.MIN_VALUE : small[xPos - 1]; 
            int r1 = xPos == small.length ? Integer.MAX_VALUE : small[xPos]; 

            int l2 = yPos == 0 ? Integer.MIN_VALUE : big[yPos-1]; 
            int r2 = yPos == big.length ? Integer.MAX_VALUE : big[yPos];

            if(l1<=r2 && l2<=r1){
                if((nums1.length + nums2.length)%2==0){
                    return ((double)Math.max(l1,l2) + Math.min(r1,r2))/2.0;
                }else{
                    return Math.max(l1,l2);
                }
            }

            if(l1 > r2){
                rp = xPos - 1;
            }else{
                lp = xPos + 1;
            }
        }
    return 0;
        
    }
}
