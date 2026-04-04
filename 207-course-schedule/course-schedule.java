class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }
        int[] inDegrees = new int[numCourses];
        for(int[] pre:prerequisites){
            adjList.get(pre[1]).add(pre[0]);
            inDegrees[pre[0]]++;
        }
        Queue<Integer> canTake = new LinkedList<>();
        int count=0;
        for(int i=0; i<numCourses; i++){
            if(inDegrees[i]==0){
                count++;
                canTake.add(i);
            }
        }
        while(!canTake.isEmpty()){
            for(int i:adjList.get(canTake.remove())){
                inDegrees[i]--;
                if(inDegrees[i]==0){
                    count++;
                    canTake.add(i);
                }
            }
        }
        return count==numCourses;
    }
}