class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hmap = new HashMap<>();
        for(String str:strs){
            char[] ch_arr = str.toCharArray();
            Arrays.sort(ch_arr);
            String s = new String(ch_arr);
            if(!hmap.containsKey(s)){
                List<String> list = new ArrayList<>();
                list.add(str);
                hmap.put(s, list);
            }
            else{
                hmap.get(s).add(str);
            }
        }
        List<List<String>> list = new ArrayList<>();
        for(Map.Entry<String, List<String>> entry: hmap.entrySet()){
            List<String> value=entry.getValue();
            list.add(value);
        }
        return list;
    }
}