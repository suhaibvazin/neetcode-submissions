class Solution {
    // 1. Define the Trie Node
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word = null; // Store the complete word at the leaf node
    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        TrieNode root = new TrieNode();

        // 2. Build the Trie with all words
        for (String w : words) {
            TrieNode curr = root;
            for (char c : w.toCharArray()) {
                int index = c - 'a';
                if (curr.children[index] == null) {
                    curr.children[index] = new TrieNode();
                }
                curr = curr.children[index];
            }
            curr.word = w; // Mark the end of the word by storing the word itself
        }

        // 3. Start a DFS from every cell on the board
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                dfs(board, r, c, root, result);
            }
        }

        return result;
    }

    // 4. The Recursive DFS function
    private void dfs(char[][] board, int r, int c, TrieNode node, List<String> result) {
        // Base Case 1: Out of bounds or already visited (the "locked door")
        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length || board[r][c] == '#') {
            return;
        }

        char ch = board[r][c];
        TrieNode nextNode = node.children[ch - 'a'];

        // Base Case 2: Pruning! If this prefix doesn't exist in the Trie, stop searching
        if (nextNode == null) {
            return;
        }

        // Did we find a word?
        if (nextNode.word != null) {
            result.add(nextNode.word);
            nextNode.word = null; // Prevent duplicates (removes the word from the Trie)
        }

        // Lock the room
        board[r][c] = '#';

        // Explore the 4 doors
        dfs(board, r - 1, c, nextNode, result); // Up
        dfs(board, r + 1, c, nextNode, result); // Down
        dfs(board, r, c - 1, nextNode, result); // Left
        dfs(board, r, c + 1, nextNode, result); // Right

        // Unlock the room for the next backtracking path
        board[r][c] = ch;
    }
}