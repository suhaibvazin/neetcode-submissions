class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);

        List<List<Integer>> ans = new ArrayList<>();

        for(int j=0 ; j<len-2 ; j++){
            if(j>0 && nums[j]==nums[j-1]){
                continue;
            }
            int target = -nums[j];  
            int l = j+1;
            int r = len-1;
            while(l<r){
                int sum = nums[l] + nums[r];
                if(sum==target){
                    ans.add(List.of(nums[j],nums[l],nums[r]));
                    if(l<r && nums[r]==nums[r-1]){
                        r--;
                    }
                    if(l<r && nums[l]==nums[l+1]){
                        l++;
                    }
                    l++;
                    r--;
                }else if (sum<target){
                    l++;
                }else{
                    r--;
                }
            }
        }

        return ans;
    }
}
