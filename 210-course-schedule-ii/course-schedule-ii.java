class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[][] vis = new int[numCourses][numCourses];
        int[] inDegrees = new int[numCourses];
        for(int i=0; i<prerequisites.length; i++){
            int pre=prerequisites[i][1];
            int curr=prerequisites[i][0];
            if(vis[pre][curr]==0){
                inDegrees[curr]++;
            }
            vis[pre][curr]=1;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<numCourses; i++){
            if(inDegrees[i]==0){
                q.add(i);
            }
        }
        int[] ans=new int[numCourses];
        int k=0;
        while(!q.isEmpty()){
            int curr=q.poll();
            ans[k]=curr;
            k++;
            for(int i=0; i<numCourses; i++){
                if(vis[curr][i]==1){
                    inDegrees[i]--;
                    if(inDegrees[i]==0){
                        q.add(i);
                    }
                }
            }
        }
        if(k!=numCourses){
            return new int[0];
        }
        return ans;       
    }
}