class Solution {
    class DisjointSet{
        List<Integer> parent = new ArrayList<>();
        List<Integer> size = new ArrayList<>();
        DisjointSet(int n){
            for(int i=0; i<n; i++){
                parent.add(i);
                size.add(1);
            }
        }
        public int ultimateP(int node){
            if(parent.get(node)==node){
                return node;
            }
            int par = ultimateP(parent.get(node));
            parent.set(node, par);
            return parent.get(node);
        }
        public void connect(int u, int v){
            int ulP_u = ultimateP(u);
            int ulP_v = ultimateP(v);
            if(ulP_u==ulP_v){
                return;
            }
            else if(size.get(ulP_u)>size.get(ulP_v)){
                parent.set(ulP_v, ulP_u);
                size.set(ulP_u, ulP_u+ulP_v);
            }
            else{
                parent.set(ulP_u, ulP_v);
                size.set(ulP_v, ulP_u+ulP_v);                
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        DisjointSet dis = new DisjointSet(isConnected.length);
        int n=isConnected.length;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(i==j){
                    continue;
                }
                if(isConnected[i][j]==1){
                    dis.connect(i, j);
                }
            }
        }
        List<Integer> p = dis.parent;
        int count=0;
        for(int i=0; i<p.size(); i++){
            if(i==p.get(i)){
                count++;
            }
        }
        return count;
    }
}