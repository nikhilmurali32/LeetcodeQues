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

class Trie {
    Node root;
    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
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
        for(int i=0; i<word.length(); i++){
            char ch=word.charAt(i);
            if(!node.containsKey(ch)){
                return false;
            }
            node = node.get(ch);
        }
        if(node.flag==true){
            return true;
        } 
        return false;       
    }
    
    public boolean startsWith(String prefix) {
        Node node = root;
        for(int i=0; i<prefix.length(); i++){
            char ch=prefix.charAt(i);
            if(!node.containsKey(ch)){
                return false;
            }
            node = node.get(ch);
        }
        return true;        
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */