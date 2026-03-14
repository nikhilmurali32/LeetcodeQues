class Solution {
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        Stack<Integer> st_left = new Stack<>();
        int[] left_max = new int[n];
        left_max[0]=1;
        st_left.push(0);

        Stack<Integer> st_right = new Stack<>();
        int[] right_max = new int[n];
        right_max[n-1]=1;
        st_right.push(n-1);

        for(int i=1; i<n; i++){
            while(!st_left.isEmpty() && heights[i]<=heights[st_left.peek()]){
                st_left.pop();
            }
            left_max[i] = st_left.isEmpty()?i+1:i-st_left.peek();
            st_left.push(i);

            while(!st_right.isEmpty() && heights[n-i-1]<=heights[st_right.peek()]){
                st_right.pop();
            }
            right_max[n-i-1] = st_right.isEmpty()?i+1:st_right.peek()-(n-i-1);
            st_right.push(n-i-1);
        }

        int max_area = 0;
        for(int i=0; i<n; i++){
            max_area = Math.max(max_area, heights[i]*(left_max[i]+right_max[i]-1));
        }
        return max_area;
    }
}