class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0; i<numCourses; i++){
            adjList.add(new ArrayList<>());
        }
        int[] inDegrees = new int[numCourses];
        for(int[] pre:prerequisites){
            adjList.get(pre[1]).add(pre[0]);
            inDegrees[pre[0]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<numCourses; i++){
            if(inDegrees[i]==0){
                q.add(i);
            }
        }
        int count=0;
        while(!q.isEmpty()){
            int curr = q.remove();
            for(int nei:adjList.get(curr)){
                inDegrees[nei]--;
                if(inDegrees[nei]==0){
                    q.add(nei);
                }
            }
            count++;
        }
        return numCourses==count;

    }
}