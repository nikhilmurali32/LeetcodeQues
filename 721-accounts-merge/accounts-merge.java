class disjointSet{
    int[] parent;
    int[] size;
    disjointSet(int n){
        parent = new int[n];
        size = new int[n];
        for(int i=0; i<n; i++){
            parent[i]=i;
            size[i]=1;
        }
    }
    public int findP(int node){
        if(parent[node]==node){
            return node;
        }
        int p = findP(parent[node]);
        parent[node]= p;
        return parent[node];
    }
    public void joinbySize(int u, int v){
        int uPar = findP(u);
        int vPar = findP(v);
        if(uPar==vPar){
            return;
        }
        else if(size[uPar]<size[vPar]){
            parent[uPar]= vPar;
            size[vPar]= size[vPar]+size[uPar];
        }
        else{
            parent[vPar]= uPar;
            size[uPar]= size[vPar]+size[uPar];
        }
    }
}


class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        disjointSet ds = new disjointSet(accounts.size());
        HashMap<String, Integer> hmap = new HashMap<>();
        for(int i=0; i<accounts.size(); i++){
            for(int j=1; j<accounts.get(i).size(); j++){
                String str = accounts.get(i).get(j);
                if(!hmap.containsKey(str)){
                    hmap.put(str, i);
                }
                else{
                    ds.joinbySize(i, hmap.get(str));
                }
            }
        }
        List<List<String>> list = new ArrayList<>();
        for(int i=0; i<accounts.size(); i++){
            list.add(new ArrayList<>());
        }
        for(Map.Entry<String, Integer> entry:hmap.entrySet()){
            String key=entry.getKey();
            int par = ds.findP(hmap.get(key));
            list.get(par).add(key);
        }
        for(int i=0; i<list.size(); i++){
            Collections.sort(list.get(i));
            list.get(i).add(0, accounts.get(i).get(0));
        }
        list.removeIf(sublist -> sublist.size()==1);
        return list;
    }
}