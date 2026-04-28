class PrefixTree {
        PrefixTree[] children;
        boolean isEndOfWord;
    public PrefixTree() {
        children = new PrefixTree[26];
        isEndOfWord = false;
    }

    public void insert(String word) {
        PrefixTree curr = this;
        for(char s : word.toLowerCase().toCharArray()){
            int index = s-'a';
            if(curr.children[index]==null){
               curr.children[index] = new PrefixTree();  
            }
            curr = curr.children[index];
        }
        curr.isEndOfWord = true;
    }

    public boolean search(String word) {
        boolean isExist;
        PrefixTree curr = this;
        String str = word.toLowerCase();
        for(char s : str.toCharArray()){
            int index = s-'a';
            if(curr.children[index]==null){
               return false; 
            }
            curr = curr.children[index];
        }
        return curr.isEndOfWord;

    }

    public boolean startsWith(String prefix) {
        PrefixTree curr = this;
        String str = prefix.toLowerCase();
        for(char s : str.toCharArray()){
            int index = s-'a';
            if(curr.children[index]==null){
               return false; 
            }
            curr = curr.children[index];
        }
        return true;
    }
}
