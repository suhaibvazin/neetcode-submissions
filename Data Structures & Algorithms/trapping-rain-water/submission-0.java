class Solution {
    public int trap(int[] height) {
        int water=0;
        int len = height.length;
        int [] left  = new int[len];
        left[0] = height[0];
        int [] right  =  new int[len];
        right[len-1] = height[len-1];
        //fill left array
        for(int i=1;i<len;i++){
            left[i]= Math.max(left[i-1],height[i]);
        }
        //fill right array
        for(int i=len-2; i>=0;i--){
            right[i]=Math.max(right[i+1],height[i]);
        }
        //find result
        for(int i=0; i<len-1 ; i++){
            int tempwater = Math.min(right[i],left[i]) - height[i];
            water+=tempwater;
        }

        return water;


        
    }
}
