class Solution {
    int[][] res;
    char ch=' ';
    int val;
    List<Integer> list;
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        list = new ArrayList<>();
        res = new int[n][n];
        int num=1;
        val=1;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                matrix[i][j] = num;
                num++;
            }
        }
        for(int i=0; i<n; i++){
            ch='r';
            dfs(matrix, i, i, n-i);
            ch=' ';
        }
        // while(!list.isEmpty()){
        //     System.out.println(list.remove(0));
        // }
        // for(int i=0; i<n; i++){
        //     for(int j=0; j<n; j++){
        //         res[i][j]=list.remove(0);
        //     }
        // }
        return res;
    }
    public void dfs(int[][] matrix, int i, int j, int n){
        if(i<matrix.length-n || i>n-1 || j<matrix[0].length-n || j>n-1 || res[i][j] != 0){
            if(j>n-1){
                ch='d';
            }
            else if(i>n-1){
                ch='l';
            }
            else if(j<matrix[0].length-n){
                ch='u';
            }
            else{
                ch=' ';
            }
            return;
        }
        System.out.println(i);
        System.out.println(j);
        System.out.println(" ");
        list.add(matrix[i][j]);
        res[i][j]=val;
        val++;
        if(ch=='r'){
            dfs(matrix, i, j+1, n);
        }
        if(ch=='d'){
            dfs(matrix, i+1, j, n);
        }
        if(ch=='l'){
            dfs(matrix, i, j-1, n);
        }
        if(ch=='u'){
            dfs(matrix, i-1, j, n);
        }
    }
}