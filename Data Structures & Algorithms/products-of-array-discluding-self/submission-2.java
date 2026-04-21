class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int [] lArr = new int [len];
        int [] rArr = new int [len];

        int [] ansArr = new int [len];

        //initialise arrays with boundary values
        lArr[0]=1;
        rArr[len-1]=1;

        //fill left array
        for(int i=1;i<len;i++){
            lArr[i]= lArr[i-1]*nums[i-1];
        }
        //fill right array
        for(int i= len-2; i>=0;i--){
            rArr[i]= rArr[i+1]*nums[i+1];
        }

        for(int i=0;i<len;i++){
            ansArr[i]= lArr[i]*rArr[i];
        }

        return ansArr;
        
    }
}  
