class Solution {
    class Task{
        char ch;
        int rem;
        int time;
        Task(char ch, int rem){
            this.ch=ch;
            this.rem=rem;
        }
    }
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for(char task:tasks){
            freq[task-'A']++;
        }
        PriorityQueue<Task> maxFreq = new PriorityQueue<>((a,b)->Integer.compare(b.rem,a.rem));
        for(int i=0; i<26; i++){
            if(freq[i]>0){
                maxFreq.add(new Task((char)('A'+i), freq[i]));
            }
        }
        int time=0;
        Queue<Task> waitingTasks = new LinkedList<>();
        int completedTasks=0;
        int totalTasks=maxFreq.size();
        while(!maxFreq.isEmpty() || completedTasks < totalTasks){
            while(!waitingTasks.isEmpty() && waitingTasks.peek().time<=time){
                maxFreq.add(waitingTasks.remove());
            }
            if(maxFreq.isEmpty()){
                int currWaitTime = waitingTasks.peek().time;
                time = currWaitTime;
                continue;
            }
            Task currTask = maxFreq.remove();
            currTask.rem--;
            currTask.time = time+n+1;
            if(currTask.rem==0){
                completedTasks++;
            }
            else{
                waitingTasks.add(currTask);
            }
            time++;
        }
        return time;
    }
}