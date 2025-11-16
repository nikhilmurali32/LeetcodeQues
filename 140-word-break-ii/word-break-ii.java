class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        int n=s.length();
        List<List<String>> dp = new ArrayList<>();
        for(int i=0; i<=n; i++){
            dp.add(new ArrayList<>());
        }
        dp.get(0).add("");
        for(int i=0; i<n; i++){
            if(!dp.isEmpty()){
                for(int j=i+1; j<=n; j++){
                    String str = s.substring(i, j);
                    if(dict.contains(str)){
                        dp.get(j).add(str);
                    }
                }
            }
        }
        List<String> list = new ArrayList<>();
        backtrack(dp, n, "", list);
        return list;
    }
    public void backtrack(List<List<String>> dp, int end, String str, List<String> list1){
        if(end==0){
            list1.add(str.trim());
            return;
        }
        for(String s:dp.get(end)){
            String path = s+" "+str;
            backtrack(dp, end-s.length(), path, list1);
        }
    }
}