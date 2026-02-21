class Solution {
    HashMap<String, List<String>> hmap;
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        hmap = new HashMap<>();
        Set<String> wordSet = new HashSet<>(wordList);
        adjList(beginWord, wordSet);
        for(String word:wordList){
            adjList(word, wordSet);
        }
        HashSet<String> hset = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        int steps=1;
        int seen=0;
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0; i<size; i++){
                String word=q.poll();
                // System.out.println(word);
                if(word.equals(endWord)){
                    seen=1;
                    return steps;
                }
                if(hset.contains(word)){
                    continue;
                }
                hset.add(word);
                if(!hmap.containsKey(word)){
                    continue;
                }
                for(String str:hmap.get(word)){
                    System.out.println(str);
                    q.offer(str);
                }
                System.out.println(" ");
            }
            steps++;
        }
        return seen==0?0:steps;        

    }
    public void adjList(String word, Set<String> wordSet){
        char[] ch_arr = word.toCharArray();
        for(int i=0; i<ch_arr.length; i++){
            char org=ch_arr[i];
            for(char c='a'; c<='z'; c++){
                if(c==org){
                    continue;
                }
                ch_arr[i]=c;
                String str=new String(ch_arr);
                if(wordSet.contains(str)){
                    // System.out.println(str);
                    if(!hmap.containsKey(word)){
                        List<String> l = new ArrayList<>();
                        l.add(str);
                        hmap.put(word, l);
                    }
                    else{
                        List<String> l = hmap.get(word);
                        l.add(str);
                        hmap.put(word, l);
                    }
                }
            }
            ch_arr[i]=org;
        }
        // System.out.println(hmap.get(word).size());
    }
}