class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> diffToIndex = new HashMap<>();

        for(int i=0 ;i<nums.length; i++){
            int diff = target - nums[i];
            if(diffToIndex.containsKey(nums[i])){
                return new int []{diffToIndex.get(nums[i]),i};
            }
            diffToIndex.put(diff,i);
        }
        return new int []{};
        
    }
}
