

class TimeMap {
    // Inner class to store the pair
    private class DataNode {
        int timestamp;
        String value;

        DataNode(int timestamp, String value) {
            this.timestamp = timestamp;
            this.value = value;
        }
    }

    private Map<String, List<DataNode>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    /**
     * Stores the key-value pair with the given timestamp.
     * Time Complexity: O(1)
     */
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(new DataNode(timestamp, value));
    }

    /**
     * Returns a value such that set was called with timestamp_prev <= timestamp.
     * Time Complexity: O(log N) where N is the number of entries for the key.
     */
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";

        List<DataNode> list = map.get(key);
        return binarySearch(list, timestamp);
    }

    private String binarySearch(List<DataNode> list, int timestamp) {
        int left = 0;
        int right = list.size() - 1;
        String res = "";

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid).timestamp <= timestamp) {
                // This is a potential candidate, look for a larger timestamp to the right
                res = list.get(mid).value;
                left = mid + 1;
            } else {
                // Too large, look to the left
                right = mid - 1;
            }
        }

        return res;
    }
}