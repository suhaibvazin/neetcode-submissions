class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = findMax(piles);

        int fallback = r;

        int ans = 0;

        while(l<r){
            int mid = l + (r-l)/2;
            if(canFinish(mid,piles,h)){   
                r = mid;
                ans = mid;
            }else{
                l = mid+1;
            }
        }

        return ans==0?fallback:ans;
        
    }

    private boolean canFinish(int k ,int[] piles,int h){
        int max = 0;
        for(int i:piles){
            max += (int) Math.ceil((double) i / k);
        }
        return max<=h;
    }

    private int findMax(int [] piles){
        int max = 0;
        for(int i:piles){
            max = Math.max(i,max);
        }
        return max;
    }
}
