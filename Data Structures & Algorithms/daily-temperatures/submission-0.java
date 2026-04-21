class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[temperatures.length];
        for(int t=0;t<temperatures.length;t++){
            while(!stack.isEmpty() && temperatures[stack.peek()]<temperatures[t]){
                int index = stack.pop();
                result[index] = t-index;
            }
            stack.push(t);
        }
        return result;
    }
}
