class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> sortedStringMap = new HashMap<>();
        for(String str:strs){
            char[] chArr = str.toCharArray();
            Arrays.sort(chArr);
            String sortedStr = String.valueOf(chArr);
            if(sortedStringMap.containsKey(sortedStr)){
                List<String> strList = sortedStringMap.get(sortedStr);
                strList.add(str);
                sortedStringMap.put(sortedStr, strList);
            }
            else{
                List<String> strList = new ArrayList<>();
                strList.add(str);
                sortedStringMap.put(sortedStr, strList);
            }
        }
        List<List<String>> res = new ArrayList<>();
        for(Map.Entry<String, List<String>> entry:sortedStringMap.entrySet()){
            res.add(entry.getValue());
        }
        return res;
    }
}