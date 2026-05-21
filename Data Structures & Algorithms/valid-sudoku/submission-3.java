class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> rowSet = new HashSet<>();
        Set<String> colSet = new HashSet<>();
        Set<String> sqSet = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char currentVal = board[i][j];
                if (currentVal == '.') {
                    continue;
                }
                if (!rowSet.add("r" + i + currentVal) || !colSet.add("c" + j + currentVal)
                    || !sqSet.add("s" + i / 3 + "_" + j / 3 + currentVal)) {
                    return false;
                }
            }
        }
        return true;
    }
}
