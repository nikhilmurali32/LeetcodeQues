class Solution {
    public String reverseWords(String s) {
        String[] strArr = s.split(" ");
        Deque<String> words = new ArrayDeque<>();
        for(String str:strArr){
            if(str.equals("")){
                continue;
            }
            words.addLast(str);
        }
        StringBuilder sb = new StringBuilder();
        while(!words.isEmpty()){
            sb.append(words.removeLast()).append(" ");
        }
        sb.setLength(sb.length()-1);
        return sb.toString();
    }
}