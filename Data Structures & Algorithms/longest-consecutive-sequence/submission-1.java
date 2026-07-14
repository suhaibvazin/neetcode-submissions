class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> hashSet = new HashSet<>();

        for (int num : nums) {
            hashSet.add(num);
        }
        int maxCount = 0;
        for (int num : nums) {
            if (!hashSet.contains(num - 1)) {
                int count = 1;
                int tempNum = num;
                while (hashSet.contains(tempNum + 1)) {
                    count++;
                    tempNum++;
                }
                maxCount = Math.max(maxCount, count);
            }
        }
        return maxCount;
    }
}
