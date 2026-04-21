class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<String,Set<Character>> sqsets = new HashMap<>();
        //row check
        for(int i=0; i<9; i++){
            Set<Character> rset = new HashSet<>();
            for(int j=0; j<9; j++){
               Character value = board[i][j];
               if (value == '.') continue;
               if(rset.contains(value)){
                return false;
               }else{
                rset.add(value);
               }
            }
        }
        // col check
        for(int i=0; i<9; i++){
            Set<Character> cset = new HashSet<>();
            for(int j=0; j<9; j++){
               Character value = board[j][i];
               if (value == '.') continue;
               if(cset.contains(value)){
                return false;
               }else{
                cset.add(value);
               }
            }
        }
        //square check
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
               Character value = board[i][j];
               if (value == '.') continue;  
               int rIndex= i/3;
               int cIndex = j/3;
               String key = "r"+rIndex+"c"+cIndex;
               Set<Character> sqset = sqsets.computeIfAbsent(key,k->new HashSet<>());
               if(sqset.contains(value)){
                return false;
               }else{
                sqset.add(value);
               }

            }
        }
        return true;
        
    }
}
