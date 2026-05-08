class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // Start exploring from index 0 with an empty bucket
        explore(0, nums, new ArrayList<>(), result);
        return result;
    }

    private void explore(int index, int[] nums, List<Integer> current, List<List<Integer>> result) {
        // Base Condition: We've made an include/exclude decision for every element
        if (index == nums.length) {
            // Add a copy of the current subset to the results
            result.add(new ArrayList<>(current));
            return;
        }

        // Decision 1: INCLUDE the current number
        current.add(nums[index]);
        explore(index + 1, nums, current, result);

        // Decision 2: EXCLUDE the current number
        // We backtrack by removing the element we just added before exploring the other branch
        current.remove(current.size() - 1);
        explore(index + 1, nums, current, result);
    }
}