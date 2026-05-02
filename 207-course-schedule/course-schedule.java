class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }
        for(int[] pre:prerequisites){
            adjList.get(pre[1]).add(pre[0]);
        }
        int[] state = new int[numCourses];
        for(int i=0; i<numCourses; i++){
            if(isCycle(i, adjList, state)){
                return false;
            }
        }
        return true;
    }
    public boolean isCycle(int course, List<List<Integer>> adjList, int[] state){
        if(state[course]==1){
            return true;
        }
        if(state[course]==2){
            return false;
        }
        state[course]=1;
        for(int i:adjList.get(course)){
            if(isCycle(i, adjList, state)){
                return true;
            }
        }
        state[course]=2;
        return false;
    }
}