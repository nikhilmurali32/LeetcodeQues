class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }
        int[] inDegrees = new int[numCourses];
        for(int[] pre:prerequisites){
            adjList.get(pre[0]).add(pre[1]);
            inDegrees[pre[1]]++;
        }
        Queue<Integer> canTake = new LinkedList<>();
        int count=0;
        for(int i=0; i<numCourses; i++){
            if(inDegrees[i]==0){
                count++;
                canTake.add(i);
            }
        }
        if(count==0){
            return false;
        }
        while(!canTake.isEmpty()){
            int course = canTake.remove();
            for(int i:adjList.get(course)){
                inDegrees[i]--;
                if(inDegrees[i]==0){
                    count++;
                    canTake.add(i);
                }
            }
            if(count==numCourses){
                return true;
            }
        }
        return false;
    }
}