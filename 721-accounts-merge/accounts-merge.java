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
        int p = findP(parent.get(node));
        parent.set(node, p);
        return parent.get(node);
    }
    public void joinbySize(int u, int v){
        int uPar = findP(u);
        int vPar = findP(v);
        if(uPar==vPar){
            return;
        }
        else if(size.get(uPar)<size.get(vPar)){
            parent.set(uPar, vPar);
            size.set(vPar, size.get(vPar)+size.get(uPar));
        }
        else{
            parent.set(vPar, uPar);
            size.set(uPar, size.get(uPar)+size.get(vPar));
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
        // int count=0;
        // for(int i=0; i<accounts.size(); i++){
        //     if(ds.findP(i)==i){
        //         count++;
        //     }
        // }
        List<List<String>> list = new ArrayList<>();
        for(int i=0; i<accounts.size(); i++){
            list.add(new ArrayList<>());
        }
        for(Map.Entry<String, Integer> entry:hmap.entrySet()){
            String key=entry.getKey();
            int par = ds.findP(hmap.get(key));
            list.get(par).add(key);
        }
        // for(List<String> l:list){
        //     // if(l.isEmpty()){
        //     //     list.remove(l);
        //     // }
        //     Collections.sort(l);
        //     l.add(accounts.get())
        // }
        for(int i=0; i<list.size(); i++){
            Collections.sort(list.get(i));
            list.get(i).add(0, accounts.get(i).get(0));
        }
        list.removeIf(sublist -> sublist.size()==1);
        return list;
    }
}