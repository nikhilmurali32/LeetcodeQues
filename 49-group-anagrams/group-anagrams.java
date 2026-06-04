class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> anagrams = new HashMap<>();
        for(String str:strs){
            char[] freq = new char[26];
            for(char ch:str.toCharArray()){
                freq[ch-'a']++;
            }
            String sorted_str = new String(freq);
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