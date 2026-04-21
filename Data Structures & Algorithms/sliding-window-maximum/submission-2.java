class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        int l =0;
        int maxValue = 0;
        List<Integer> list = new ArrayList<>();
        int r =0;
        while(r<nums.length){
            int n = nums[r];
            maxValue = Math.max(maxValue,n);
            if(r-l+1>k){
                if(nums[l]==maxValue){
                    r=l+1;
                    maxValue = nums[r];
                }
                l++;
            }
            if(r-l+1==k){
                list.add(maxValue);
            }
            r++;
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
        
    }
}
