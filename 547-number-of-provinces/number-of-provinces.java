// int count=0;
class disjointSet{
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();
    int components;
    disjointSet(int n){
        components=n;
        for(int i=0; i<n; i++){
            parent.add(i);
            size.add(1);
        }
    }
    public int ulp(int node){
        if(parent.get(node)==node){
            return node;
        }
        int par = ulp(parent.get(node));
        parent.set(node, par);
        return parent.get(node);
    }
    public void joinBySize(int u, int v){
        int ulp_u=ulp(u);
        int ulp_v=ulp(v);
        if(ulp_u==ulp_v){
            return;
        }
        else if(size.get(ulp_u)<size.get(ulp_v)){
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_v)+size.get(ulp_u));
        }
        else{
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u)+size.get(ulp_v));
        }
        components--;
    }
}
class Solution {
    public int findCircleNum(int[][] isConnected) {
        disjointSet dis = new disjointSet(isConnected.length);
        // int count=0;
        for(int i=0; i<isConnected.length; i++){
            for(int j=0; j<isConnected[i].length; j++){
                if(i==j){
                    continue;
                }
                else if(isConnected[i][j]==1){
                    dis.joinBySize(i, j);
                }
            }
        }
        return dis.components;
    }
}