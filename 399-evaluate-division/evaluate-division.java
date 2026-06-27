class Solution {
    class Node{
        String str;
        double wt;
        Node(String str, double wt){
            this.str=str;
            this.wt=wt;
        }
    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<Node>> hmap = new HashMap<>();
        for(int i=0; i<equations.size(); i++){
            String str1=equations.get(i).get(0);
            String str2=equations.get(i).get(1);
            hmap.putIfAbsent(str1, new ArrayList<>());
            hmap.putIfAbsent(str2, new ArrayList<>());
            hmap.get(str1).add(new Node(str2, values[i]));
            hmap.get(str2).add(new Node(str1, 1/values[i]));
        }
        double[] ans = new double[queries.size()];
        int ind=0;
        for(List<String> query:queries){
            ans[ind] = dfs(query.get(0), query.get(1), hmap, new HashSet<>());
            ind++;
        }
        return ans; 
    }
    public double dfs(String s, String t, Map<String, List<Node>> hmap, HashSet<String> hset){
        if(!hmap.containsKey(s)){
            return -1;
        }
        if(s.equals(t)){
            return 1;
        }
        hset.add(s);
        for(Node node:hmap.get(s)){
            if(!hset.contains(node.str)){
                double ans= dfs(node.str, t, hmap, hset);
                if(ans!=-1){
                    return node.wt*ans;
                }
            }
        }
        return -1;
    }
}