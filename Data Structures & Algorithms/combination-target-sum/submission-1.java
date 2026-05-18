class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(0, nums, 0, res, target, new ArrayList<>());
        return res;
    }

    private void backtrack(int total, int[] nums, int index, List<List<Integer>> res, int target,
        List<Integer> current) {
        if (target == total) {
            res.add(new ArrayList<>(current));
            return;
        }

        if (total > target || index >= nums.length) {
            return;
        }

        // add the num to current
        current.add(nums[index]);
        backtrack(total + nums[index], nums, index, res, target, current);
        // once we reach breach the target or go out of index
        // exclude
        current.remove(current.size() - 1);
        backtrack(total, nums, index + 1, res, target, current);
    }
}