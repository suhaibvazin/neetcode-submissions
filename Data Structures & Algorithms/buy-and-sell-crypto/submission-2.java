class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int profit = 0;

        for(int price:prices){
            if(price<min){
                min = price;
            }
            int c_profit = price-min;
            if( c_profit > profit){
                profit = c_profit;
            }
        }
        return profit;
    }
}
