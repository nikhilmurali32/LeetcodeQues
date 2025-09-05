class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String, Integer> hmap = new HashMap<>();
        for(int i=0; i<list1.length; i++){
            hmap.put(list1[i], i);
        }
        int min=Integer.MAX_VALUE;
        List<String> list = new ArrayList<>();
        for(int j=0; j<list2.length; j++){
            if(hmap.containsKey(list2[j])){
                if(hmap.get(list2[j])+j<min){
                    list.removeAll(list);
                    list.add(list2[j]);
                    min=hmap.get(list2[j])+j;
                }
                else if(hmap.get(list2[j])+j==min){
                    list.add(list2[j]);
                }
            }
        }
        String[] res = new String[list.size()];
        for(int k=0; k<list.size(); k++){
            res[k]=list.get(k);
        }
        return res;
    }
}