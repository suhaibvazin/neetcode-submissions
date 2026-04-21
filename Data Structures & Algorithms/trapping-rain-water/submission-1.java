class Solution {
    public int trap(int[] height) {
        int len = height.length;
        int [] lrray = new int[len];
        int [] rrray = new int[len];

        int area = 0;

        for(int i=1; i<len; i++){
            lrray[i] = Math.max(lrray[i-1],height[i-1]);
        }

        for(int i=len-2; i>=0; i--){
            rrray[i] = Math.max(rrray[i+1],height[i+1]);
        }

        for(int i=0; i<len; i++){
            int maxHeight = Math.min(lrray[i],rrray[i]);
            if(height[i]<maxHeight){
                area += maxHeight-height[i];
            }
        }
        return area;
        
    }
}
