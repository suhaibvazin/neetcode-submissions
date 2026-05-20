class Solution {

    public String encode(List<String> strs) {
        StringBuilder encodedString = new StringBuilder();
        
        for (String s : strs) {
            // Append the length, a delimiter, and the actual string
            encodedString.append(s.length()).append('#').append(s);
        }
        
        return encodedString.toString();
    }

    public List<String> decode(String str) {
        List<String> decodedStrs = new ArrayList<>();
        int i = 0;
        
        while (i < str.length()) {
            int j = i;
            // Find the delimiter to isolate the length integer
            while (str.charAt(j) != '#') {
                j++;
            }
            
            // Parse the length of the upcoming string
            int length = Integer.parseInt(str.substring(i, j));
            
            // The actual string starts after the '#' and ends after 'length' characters
            int startOfStr = j + 1;
            int endOfStr = startOfStr + length;
            
            decodedStrs.add(str.substring(startOfStr, endOfStr));
            
            // Move the pointer to the start of the next encoded block
            i = endOfStr;
        }
        
        return decodedStrs;
    }
}