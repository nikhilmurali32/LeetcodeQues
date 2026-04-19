class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for(char task:tasks){
            freq[task-'A']++;
        }
        PriorityQueue<Integer> maxFreq = new PriorityQueue<>((a,b) -> (b-a));
        for(int task: freq){
            if(task>0){
                maxFreq.add(task);
            }
        }
        Queue<int[]> waiting = new LinkedList<>();
        int timer=0;
        while(!maxFreq.isEmpty() || !waiting.isEmpty()){
            if(!maxFreq.isEmpty()){
                int currTask = maxFreq.poll();
                currTask--;
                if(currTask>0){
                    waiting.add(new int[]{currTask, timer+n});
                }
            }
            if(!waiting.isEmpty() && waiting.peek()[1]==timer){
                int[] freeTask = waiting.remove();
                maxFreq.add(freeTask[0]);
            }
            timer++;
        }
        return timer;
    }
}