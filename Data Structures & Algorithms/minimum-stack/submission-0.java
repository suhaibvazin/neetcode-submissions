class MinStack {
    private List<int[]> stack = new ArrayList<>(); // [value, minAtThisLevel]

    public void push(int val) {
        if (stack.isEmpty()) {
            stack.add(new int[]{val, val});
        } else {
            int currentMin = stack.get(stack.size() - 1)[1];
            stack.add(new int[]{val, Math.min(val, currentMin)});
        }
    }

    public void pop() {
        stack.remove(stack.size() - 1);
    }

    public int top() {
        return stack.get(stack.size() - 1)[0];
    }

    public int getMin() {
        return stack.get(stack.size() - 1)[1];
    }
}