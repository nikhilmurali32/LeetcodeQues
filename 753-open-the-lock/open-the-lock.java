class Solution {
    public int openLock(String[] deadends, String target) {
        // List<String> deadList = Arrays.asList(deadends);
        Set<String> deadList = new HashSet<>(Arrays.asList(deadends));
        if(deadList.contains("0000")) return -1;
        Queue<String> q = new LinkedList<>();
        HashSet<String> hset = new HashSet<>();
        q.offer("0000");
        hset.add("0000");
        int steps=0;
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0; i<size; i++){
                String comb = q.poll();
                if(comb.equals(target)){
                    return steps;
                }
                for(String nei:neighbors_f(comb)){
                    if(!deadList.contains(nei) && !hset.contains(nei)){
                        q.offer(nei);
                        hset.add(nei);
                    }
                }
            }
            steps++;
        }
        return -1;
    }
    public List<String> neighbors_f(String s){
        List<String> res = new ArrayList<>();

        char[] arr = s.toCharArray();

        for(int i=0;i<4;i++){
            char old = arr[i];

            // turn forward
            arr[i] = (char)((old - '0' + 1) % 10 + '0');
            res.add(new String(arr));

            // turn backward
            arr[i] = (char)((old - '0' + 9) % 10 + '0');
            res.add(new String(arr));

            arr[i] = old;
        }

        return res;
    }
}