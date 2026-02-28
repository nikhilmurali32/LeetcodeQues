class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character,Integer> hmap = new HashMap<>();
        for(char task:tasks){
            hmap.put(task, hmap.getOrDefault(task,0)+1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b-a);
        for(Map.Entry<Character, Integer> entry:hmap.entrySet()){
            pq.add(entry.getValue());
        }
        int steps=0;
        while(!pq.isEmpty()){
            int cycle=n+1;
            List<Integer> list = new ArrayList<>();
            while(cycle>0 && !pq.isEmpty()){
                int ele=pq.poll();
                if(ele>0){
                    ele--;
                    list.add(ele);
                }
                cycle--;
                steps++;
            }
            for(int i:list){
                if(i>0){
                    pq.add(i);
                }
            }
            if(!pq.isEmpty()){
                steps += cycle;
            }
        }
        return steps;

    }
}