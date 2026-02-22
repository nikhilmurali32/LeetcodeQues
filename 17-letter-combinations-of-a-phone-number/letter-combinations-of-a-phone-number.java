class Solution {
    List<String> list;
    String[] str_arr;
    public List<String> letterCombinations(String digits) {
        list = new ArrayList<>();
        str_arr = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        helper(digits, 0, "");
        return list;
    }
    public void helper(String digits, int ind, String str){
        if(ind==digits.length()){
            list.add(str);
            return;
        }
        int x = Integer.valueOf(digits.charAt(ind)-'0');
        for(char ch:str_arr[x].toCharArray()){
            helper(digits, ind+1, str+ch);
        }
    }
}