class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list = new ArrayList<>();
        HashMap<String, List<String>> hmap = new HashMap<>();
        for(String str:strs){
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String base_str = Arrays.toString(arr);
            List<String> str_list = hmap.getOrDefault(base_str, new ArrayList<>());
            str_list.add(str);
            hmap.put(base_str, str_list);
        }
        for(Map.Entry<String, List<String>> entry:hmap.entrySet()){
            List<String> val = entry.getValue();
            list.add(val);
        }
        return list;
    }
}