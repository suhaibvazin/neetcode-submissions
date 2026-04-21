class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int p1 =0;
        int p2 = numbers.length-1;
        while(p1<p2){
            while(p1<p2 && numbers[p1]+numbers[p2] > target){
                p2--;
            }
            while(p1<p2 && numbers[p1]+numbers[p2] < target){
                p1++;
            }
            if(numbers[p1]+numbers[p2]==target){
                return new int [] {p1+1,p2+1};
            }
            p2--;
        }
        return new int [] {};
    }

}