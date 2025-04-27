class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
        HashMap<Integer, List<Integer>> hmap_x = new HashMap<>();
        HashMap<Integer, List<Integer>> hmap_y = new HashMap<>();
        for(int[] building:buildings){
            List<Integer> list_x = hmap_x.getOrDefault(building[0], new ArrayList<>());
            list_x.add(building[1]);
            hmap_x.put(building[0], list_x);
            List<Integer> list_y = hmap_y.getOrDefault(building[1], new ArrayList<>());
            list_y.add(building[0]);
            hmap_y.put(building[1], list_y);
        }

        for(int key:hmap_x.keySet()){
            Collections.sort(hmap_x.get(key));
        }
        for(int key:hmap_y.keySet()){
            Collections.sort(hmap_y.get(key));
        }
        int count=0;
        for(int[] building:buildings){
            int x=building[0];
            int y=building[1];
            boolean left=false;
            boolean right=false;
            boolean top=false;
            boolean down=false;
            List<Integer> list_x=hmap_x.get(x);
            List<Integer> list_y=hmap_y.get(y);
            int len_x=list_x.size();
            int len_y=list_y.size();
            if(list_x.get(0)<y){
                top=true;
            }
            if(list_x.get(len_x-1)>y){
                down=true;
            }
            if(list_y.get(0)<x){
                left=true;
            }
            if(list_y.get(len_y-1)>x){
                right=true;
            }
            if(top&&down&&left&&right){
                count++;
            }
        }
        return count;
    }
}