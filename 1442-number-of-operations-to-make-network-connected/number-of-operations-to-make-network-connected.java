class disjointSet{
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();
    disjointSet(int n){
        for(int i=0; i<n; i++){
            parent.add(i);
            size.add(1);
        }
    }
    public int findP(int node){
        if(parent.get(node)==node){
            return node;
        }
        int par = findP(parent.get(node));
        parent.set(node, par);
        return parent.get(node);
    }
    public void joinbySize(int u, int v){
        int u_parent=findP(u);
        int v_parent=findP(v);
        if(u_parent==v_parent){
            return;
        }
        else if(size.get(u_parent)<size.get(v_parent)){
            parent.set(u_parent, v_parent);
            size.set(v_parent, size.get(v_parent)+size.get(u_parent));
        }
        else{
            parent.set(v_parent, u_parent);
            size.set(u_parent, size.get(u_parent)+size.get(v_parent));
        }
    }
}
class Solution {
    public int makeConnected(int n, int[][] connections) {
        disjointSet ds = new disjointSet(n);
        int extra=0;
        for(int[] connection:connections){
            if(ds.findP(connection[0])==ds.findP(connection[1])){
                extra++;
            }
            else{
                ds.joinbySize(connection[0], connection[1]);
            }
        }
        int count=0;
        for(int i=0; i<n; i++){
            if(ds.findP(i)==i){
                count++;
            }
        }
        if(count==0){
            return 0;
        }
        return extra-(count-1)>=0?Math.min(extra,count-1):-1;
    }
}