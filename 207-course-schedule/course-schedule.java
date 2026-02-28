class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0; i<numCourses; i++){
            adjList.add(new ArrayList<>());
        }
        for(int[] preReq:prerequisites){
            adjList.get(preReq[1]).add(preReq[0]);
        }
        int[] inDegrees = new int[numCourses];
        for(int i=0; i<inDegrees.length; i++){
            for(int j:adjList.get(i)){
                inDegrees[j]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<inDegrees.length; i++){
            if(inDegrees[i]==0){
                q.add(i);
            }
        }
        if(q.isEmpty()){
            return false;
        }
        int count=0;
        while(!q.isEmpty()){
            count++;
            for(int nei:adjList.get(q.poll())){
                // if(vis[nei]){
                //     return false;
                // }
                inDegrees[nei]--;
                if(inDegrees[nei]==0){
                    q.offer(nei);
                }
            }
        }
        return count==numCourses;
    }
}