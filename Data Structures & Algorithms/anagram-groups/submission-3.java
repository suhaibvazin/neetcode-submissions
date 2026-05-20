
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        
        for (String s : strs) {
            int[] count = new int[26];
            
            // Count frequencies of each character
            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }
            
            // Arrays.toString() turns the int array into a distinct string like "[1, 0, 0, 1...]"
            // This acts as a unique signature for all anagrams
            String key = Arrays.toString(count);
            
            // If this is the first time seeing this signature, create a new list
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            
            // Add the original string to the corresponding list
            map.get(key).add(s);
        }
        
        // Return all the grouped lists
        return new ArrayList<>(map.values());
    }
}