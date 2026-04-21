class Solution {
    public int findDuplicate(int[] nums) {
        //hare tortoise algorith
        
        int tor = 0;
        int har = 0;
        //find intersection
        
        do {
            tor = nums[tor];
            har = nums[nums[har]]; 
        }
        while (tor!=har);

        //reset tortoise

        tor =0;

        //iterate both by one step till you find intersection
        do {
            tor = nums[tor];
            har = nums[har]; 
        }
        while (tor!=har);

        return tor;

        
    }
}
