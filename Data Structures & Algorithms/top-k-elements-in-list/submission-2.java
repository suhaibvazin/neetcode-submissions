class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // find frequency(map)
        // create array[list],where index is frequency and list contains number that
        // hold the frequency
        // iterate from behind by limit k

        Map<Integer, Integer> freqMap = new HashMap<>();
        // calculate frequency
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // plant frequency in frequency buckets
        List<Integer>[] bucket = new List[nums.length + 1];

        for (int i = 0; i < bucket.length; i++) {
            bucket[i] = new ArrayList<>();
        }

        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            bucket[entry.getValue()].add(entry.getKey());
        }

        // prepare result
        int[] res = new int[k];
        int count = 0;

        for (int i = bucket.length - 1; count < k && i >= 0; i--) {
            List<Integer> ans = bucket[i];
            for (int n : ans) {
                res[count++] = n;
                if (count == k)
                    break;
            }
        }
        return res;
    }
}
