class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0; i<numCourses; i++){
            adjList.add(new ArrayList<>());
        }
        int[] indegrees = new int[numCourses];
        for(int[] pre:prerequisites){
            adjList.get(pre[1]).add(pre[0]);
            indegrees[pre[0]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<indegrees.length; i++){
            if(indegrees[i]==0){
                q.add(i);
            }
        }
        int tot=0;
        while(!q.isEmpty()){
            int curr = q.remove();
            tot++;
            for(int course:adjList.get(curr)){
                indegrees[course]--;
                if(indegrees[course]==0){
                    q.add(course);
                }
            }
        }
        return tot==numCourses;
    }
}