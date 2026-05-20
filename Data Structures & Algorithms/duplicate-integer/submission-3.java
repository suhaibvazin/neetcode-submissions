class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> copySet = new HashSet<>();

        for(int num : nums){
            if(copySet.contains(num)){
                return true;
            }
            copySet.add(num);
        }
        return false;
    }
}