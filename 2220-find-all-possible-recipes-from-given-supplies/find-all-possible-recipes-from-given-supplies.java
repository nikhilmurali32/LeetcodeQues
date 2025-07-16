class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        HashMap<String, Integer> inDegrees = new HashMap<>();
        HashMap<String, List<String>> graph = new HashMap<>();
        Set<String> sup = new HashSet<>(Arrays.asList(supplies));

        for(int i=0; i<recipes.length; i++){
            String recipe = recipes[i];
            inDegrees.put(recipe, ingredients.get(i).size());
            for(String ing:ingredients.get(i)){
                graph.computeIfAbsent(ing, k->new ArrayList<>()).add(recipe);
            }
        }
        Queue<String> q = new LinkedList<>(sup);
        List<String> res = new ArrayList<>();
        while(!q.isEmpty()){
            String su = q.poll();
            if(!graph.containsKey(su)){
                continue;
            }
            for(String str:graph.get(su)){
                inDegrees.put(str, inDegrees.get(str)-1);
                if(inDegrees.get(str)==0){
                    q.add(str);
                    res.add(str);
                }
            }
        }
        return res;
    }
}