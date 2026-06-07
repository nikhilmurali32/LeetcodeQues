class Solution {
    // time to reach = [1, 1, 12, 7, 6]
    // sort TtoReach = [[10,1], [8,1], [5,7], [3,6], [0, 12]]
    public int carFleet(int target, int[] position, int[] speed) {
        int n=position.length;
        double[][] time = new double[n][2];
        for(int i=0; i<n; i++){
            time[i][0]=target-position[i];
            time[i][1]=((double)(target-position[i])/speed[i]);
            System.out.println(time[i][1]);
        }
        Arrays.sort(time, (a,b) -> Double.compare(a[0], b[0]));
        int i=0;
        Deque<Double> stack = new ArrayDeque<>();
        while(i<n){
            if(stack.isEmpty() || stack.peekLast()<time[i][1]){
                stack.addLast(time[i][1]);
            }
            i++;
        }
        return stack.size();
    }
}