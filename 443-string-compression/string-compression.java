class Solution {
    public int compress(char[] chars) {
        int ind=0, indAns=0;
        while(ind < chars.length){
            char curr = chars[ind];
            int count=0;
            while(ind<chars.length && chars[ind]==curr){
                ind++;
                count++;
            }
            chars[indAns++] = curr;
            if(count != 1){
                for(char ch:Integer.toString(count).toCharArray()){
                    chars[indAns++] = ch;
                }
            }
        }
        return indAns;
    }
}