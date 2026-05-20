

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // 1. Count the frequency of each number
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        // 2. Create buckets where the index represents the frequency
        // The maximum frequency can be nums.length
        List<Integer>[] buckets = new List[nums.length + 1];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }

        // 3. Group numbers by their frequency
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            int freq = entry.getValue();
            buckets[freq].add(entry.getKey());
        }

        // 4. Gather the top k frequent elements starting from the highest frequency
        int[] res = new int[k];
        int index = 0;
        for (int i = buckets.length - 1; i >= 0 && index < k; i--) {
            for (int num : buckets[i]) {
                res[index++] = num;
                if (index == k) {
                    return res;
                }
            }
        }
        
        return res;
    }
}