class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> hset = new HashSet<>(wordList);
        if(!hset.contains(endWord)){
            return 0;
        }
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        int steps=1;
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0; i<size; i++){
                String word = q.poll();
                if(word.equals(endWord)){
                    return steps;
                }
                List<String> list = getNeighbours(word, hset);
                for(String str:list){
                    q.add(str);
                }
            }
            steps++;
        }
        return 0;
    }
    public List<String> getNeighbours(String word, Set<String> hset){
        List<String> res = new ArrayList<>();
        char[] str_arr = word.toCharArray();
        for(int i=0; i<word.length(); i++){
            char org = str_arr[i];
            for(char c='a'; c<='z'; c++){
                if(c==org){
                    continue;
                }
                str_arr[i]=c;
                String new_word = new String(str_arr);
                if(hset.remove(new_word)){
                    res.add(new_word);
                }
            }
            str_arr[i]=org;
        }
        return res;
    }
}