class Solution {
    public int maxArea(int[] height) {
        int len = height.length;
        int p1 =0;
        int p2= len-1;
        int finalArea = 0;
        while(p1<p2){
            int area = 0;
            int b = p2-p1;
            int l = Math.min(height[p1],height[p2]);
            area = l*b;
            finalArea= Math.max(finalArea,area);
            if(height[p1]<height[p2]){
                p1++;
            }else if (height[p1]>height[p2]){
                p2--;
            }else{
                 p1++;
            }
        }
        return finalArea;
    }
}