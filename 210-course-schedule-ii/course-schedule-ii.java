class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>(numCourses);
        int[] order = new int[numCourses];
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
        int ind=0, sum=0;
        while(!canTake.isEmpty()){
            int curr = canTake.remove();
            sum += curr;
            order[ind]=curr;
            ind++;
            for(int i:adjList.get(curr)){
                inDegrees[i]--;
                if(inDegrees[i]==0){
                    count++;
                    canTake.add(i);
                }
            }
        }
        return sum==(numCourses*(numCourses-1)/2)?order:new int[0];      
    }
}