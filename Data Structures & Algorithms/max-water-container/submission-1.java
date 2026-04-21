class Solution {
    public int maxArea(int[] heights) {
        int len = heights.length-1;
        int l = 0;
        int r = heights.length-1;

        int maxArea = 0;

        while(l<r){
            int area = Math.min(heights[l],heights[r]) * (r-l);
            if(heights[l] > heights[r]){
                r--;
            }else{
                l++;
            }
            maxArea = Math.max(maxArea,area);
        }
        return maxArea;
        
    }
}
