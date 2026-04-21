class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int l =0;
        int r =0;
        Deque<Integer> deque = new ArrayDeque<>();
        int [] ans = new int[n-k+1];
        while(r<nums.length){
            while(!deque.isEmpty() && deque.peekFirst()<r-k+1){
                deque.pollFirst();
            }
            while(!deque.isEmpty() && nums[deque.peekLast()]<nums[r]){
                deque.pollLast();
            }
            deque.offerLast(r);
            if(r >= k-1){
                ans[r-k+1] = nums[deque.peekFirst()];
            }
            r++;
        }
        return ans;
        
    }
}
