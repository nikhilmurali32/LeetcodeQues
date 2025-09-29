class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[][] vis = new int[numCourses][numCourses];
        int[] inDegrees = new int[numCourses];
        for(int i=0; i<prerequisites.length; i++){
            int curr=prerequisites[i][0];
            int prev=prerequisites[i][1];
            inDegrees[curr]++;
            vis[prev][curr]=1;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<numCourses; i++){
            if(inDegrees[i]==0){
                q.add(i);
            }
        }
        int count=0;
        while(!q.isEmpty()){
            int ele = q.poll();
            count++;
            for(int i=0; i<numCourses; i++){
                if(vis[ele][i]==1){
                    inDegrees[i]--;
                    if(inDegrees[i]==0){
                        q.add(i);
                    }
                }
            }
        }
        return count==numCourses;
    }
}