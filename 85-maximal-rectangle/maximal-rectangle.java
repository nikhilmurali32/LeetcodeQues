class Solution {
    int res=0;
    public int maximalRectangle(char[][] matrix) {
        int n=matrix.length, m=matrix[0].length;
        int[] height = new int[m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(matrix[i][j]=='1'){
                    height[j]++;
                }
                else{
                    height[j]=0;
                }
            }
            rectangleArea(height);
        }
        return res;
    }
    public void rectangleArea(int[] heights){
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<heights.length+1; i++){
            int h=(i==heights.length?0:heights[i]);
            while(!st.isEmpty() && h<heights[st.peek()]){
                int height = heights[st.pop()];
                int width = st.isEmpty()?i:i-st.peek()-1;
                res = Math.max(res, height*width);
            }
            st.push(i);
        }
    }
}