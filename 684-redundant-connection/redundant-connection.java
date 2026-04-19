class Solution {
int[] res = new int[2];
class DisjointSet{
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();
    DisjointSet(int n){
        for(int i=0; i<n+1; i++){
            parent.add(i);
            size.add(1);
        }
    }
    public int findParent(int node){
        if(parent.get(node)==node){
            return node;
        }
        int par = findParent(parent.get(node));
        parent.set(node, par);
        return parent.get(node);
    }
    public void joinBySize(int u, int v){
        int ulp_u = findParent(u);
        int ulp_v = findParent(v);
        if(ulp_u==ulp_v){
            res[0]=u;
            res[1]=v;
            return;
        }
        else if(size.get(ulp_u)<size.get(ulp_v)){
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_u)+size.get(ulp_v));
        }
        else{
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u)+size.get(ulp_v));            
        }
    }

}
    public int[] findRedundantConnection(int[][] edges) {
        DisjointSet dis = new DisjointSet(edges.length);
        for(int[] edge:edges){
            dis.joinBySize(edge[0], edge[1]);
        }
        return res;
    }
}