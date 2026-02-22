class Solution {
    public List<String> letterCombinations(String digits) {
        String[] str_arr = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        Queue<String> q = new LinkedList<>();
        q.offer("");
        for(int i=0; i<digits.length(); i++){
            int x = Integer.valueOf(digits.charAt(i)-'0');
            while(q.peek().length()==i){
                String str = q.poll();
                for(char ch:str_arr[x].toCharArray()){
                    q.add(str+ch);
                }
            }
        }
        List<String> list = new ArrayList<>(q);
        // while(!q.isEmpty()){
        //     list.add(q.poll());
        // }
        return list;

    }
}