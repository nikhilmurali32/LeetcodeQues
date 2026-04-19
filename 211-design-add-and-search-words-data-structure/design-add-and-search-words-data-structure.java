class Node{
    Node[] links = new Node[26];
    boolean flag = false;
    boolean containsKey(char c){
        return links[c-'a']!=null;
    }
    Node get(char c){
        return links[c-'a'];
    }
    void put(Node n, char c){
        links[c-'a'] = n;
    }
    void setNode(){
        flag=true;
    }
}

class WordDictionary {
    Node root;
    public WordDictionary() {
        root = new Node();
    }
    
    public void addWord(String word) {
        Node node = root;
        for(int i=0; i<word.length(); i++){
            char ch=word.charAt(i);
            if(!node.containsKey(ch)){
                node.put(new Node(), ch);
            }
            node = node.get(ch);
        }
        node.setNode();        
    }
    
    public boolean search(String word) {
        Node node = root;
        return searchHelper(node, word, 0);
        
    }
public boolean searchHelper(Node node, String word, int index){
    // 1. Base case: we reached the end of the word
    if(index == word.length()){
        return node.flag;
    }
    
    char ch = word.charAt(index);
    
    // 2. The wildcard branch
    if(ch == '.'){
        for(int i = 0; i < 26; i++){
            if(node.links[i] != null){
                // Recursive call goes here!
                if(searchHelper(node.links[i], word, index+1)){
                    return true;
                }
            }
        }
        return false; // If all 26 paths fail, return false
    } 
    // 3. The normal character branch
    else {
        if(!node.containsKey(ch)){
            return false;
        }
        // Move to the specific child node and advance the index by 1
        return searchHelper(node.get(ch), word, index + 1); 
    }
}
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */