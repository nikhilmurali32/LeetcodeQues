class Solution {
    public String removeKdigits(String num, int k) {
        Deque<Integer> ans = new ArrayDeque<>();
        int i=0, n=num.length();
        while(i<n){
            while(!ans.isEmpty() && k>0 && num.charAt(i)-'0' < ans.peekLast()){
                ans.removeLast();
                k--;
            }
            ans.addLast(num.charAt(i)-'0');
            i++;
        }
        while(k>0){
            ans.removeLast();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        while(!ans.isEmpty()){
            sb.append(ans.removeLast());
        }
        while(sb.length()>0 && sb.charAt(sb.length()-1)=='0'){
            sb.deleteCharAt(sb.length()-1);
        }
        if(sb.length()==0){
            return "0";
        }
        sb.reverse();
        return sb.toString();
    }
}