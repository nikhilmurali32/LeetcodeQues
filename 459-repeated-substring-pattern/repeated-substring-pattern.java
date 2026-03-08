class Solution {
    public boolean repeatedSubstringPattern(String s) {
        String str="";
        for(int i=0; i<s.length(); i++){
            str += s.charAt(i);
            if(s.charAt(i)==s.charAt(s.length()-1) && check(s, str)){
                return true;
            }
        }
        return false;
    }
    public boolean check(String s, String str){
        int len=s.length();
        int n=str.length();
        System.out.println(n);
        int i=n;
        if(i+n>len){
            return false;
        }
        while(i+n<=len){
            if(!s.substring(i, i+n).equals(str)){
                return false;
            }
            i=i+n;
        }
        if(i!=s.length()){
            return false;
        }
        return true;
    }
}