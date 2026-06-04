class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> anagrams = new HashMap<>();
        for(String str:strs){
            char[] ch_arr = str.toCharArray();
            Arrays.sort(ch_arr);
            String sorted_str = new String(ch_arr);
            if(!anagrams.containsKey(sorted_str)){
                anagrams.put(sorted_str, new ArrayList<>());
            }
            anagrams.get(sorted_str).add(str);
        }
        List<List<String>> res = new ArrayList<>();
        for(Map.Entry<String, List<String>> entry:anagrams.entrySet()){
            List<String> list = entry.getValue();
            res.add(list);
        }
        return res;
    }
}