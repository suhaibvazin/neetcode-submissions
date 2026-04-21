class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        Set<String> op = new HashSet<>();
        op.add("+");
        op.add("-");
        op.add("*");
        op.add("/");

        for(String token:tokens){
            if(op.contains(token)){
               int ans; 
               int b = stack.pop();
               int a = stack.pop();
               if(token.equals("+")){
                ans = a + b;
               }else if(token.equals("*")){
                ans = a * b;
               }else if(token.equals("-")){
                ans = a - b;
               }else{
                ans = a / b;
               }
               stack.push(ans);
            }else{
                stack.push(Integer.parseInt(token));
            }
            
        }
        return stack.pop();

    }
}
