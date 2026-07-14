class Solution {
    public int[] productExceptSelf(int[] nums) {
        //prepare left side sum and right side sum for each index
        //multiply both to get the final answer

        //left product array
        int [] leftArray = new int[nums.length];
        leftArray[0]=1;
        //right product array
        int [] rightArray = new int[nums.length];
        rightArray[nums.length-1]=1;

        //calculate left sum for each index
        for(int i=1;i<nums.length;i++){
            leftArray[i]= leftArray[i-1]*nums[i-1];
        }

        //calculate right sum for each index
        for(int i =nums.length-2;i>=0;i--){
            rightArray[i] = rightArray[i+1]*nums[i+1];
        }

        // populate result
        int [] ans = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            ans[i]=rightArray[i]*leftArray[i];
        }
        return ans;
    }
}  
