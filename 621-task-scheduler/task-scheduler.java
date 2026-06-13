class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        int max=0, maxCount=0;
        for(char task:tasks){
            freq[task-'A']++;
            if(freq[task-'A']==max){
                maxCount++;
            }
            else if(freq[task-'A']>max){
                max=freq[task-'A'];
                maxCount=1;
            }   
        }
        int partCount = max-1;
        int partLength = n-(maxCount-1);
        int emptySlots = partCount*partLength;
        int availableTasks = tasks.length-max*maxCount;
        int idles = Math.max(0, emptySlots-availableTasks);
        return tasks.length+idles;
    }
}