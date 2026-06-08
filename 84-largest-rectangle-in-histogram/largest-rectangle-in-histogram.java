class Solution {
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        int[] leftMax = new int[n];
        Deque<Integer> stackLeft = new ArrayDeque<>();
        int[] rightMax = new int[n];
        Deque<Integer> stackRight = new ArrayDeque<>();
        for(int i=0; i<n; i++){
            while(!stackLeft.isEmpty() && heights[i]<=heights[stackLeft.peekLast()]){
                stackLeft.removeLast();
            }
            leftMax[i] = stackLeft.isEmpty()?i+1:i-stackLeft.peekLast();
            stackLeft.addLast(i);

            while(!stackRight.isEmpty() && heights[n-i-1]<=heights[stackRight.peekLast()]){
                stackRight.removeLast();
            }
            rightMax[n-i-1] = stackRight.isEmpty()?n-(n-i)+1:stackRight.peekLast()-(n-i-1);
            stackRight.addLast(n-i-1);
        }
        int maxHeight=0;
        for(int i=0; i<n; i++){
            maxHeight = Math.max(maxHeight, (leftMax[i]+rightMax[i]-1)*heights[i]);
        }
        return maxHeight;
    }
}