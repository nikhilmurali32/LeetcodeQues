class Solution {
    public int compress(char[] chars) {
        if(chars.length==1){
            return 1;
        }
        int i=0, j=1, ind=0;
        while(i<j && j<chars.length){
            if(chars[j]==chars[i]){
                j++;
            }
            else{
                chars[ind]=chars[i];
                ind++;
                System.out.println(ind);
                if(j-i==1){
                    i=j;
                    j++;
                    continue;
                }
                else if((j-i)<10){
                    chars[ind]=(char)(j-i+'0');
                }
                else{                    
                    String str = String.valueOf(j-i);
                    for(char ch: str.toCharArray()){
                        chars[ind]=ch;
                        ind++;
                    }
                    i=j;
                    j++;
                    continue;
                }
                ind++;
                i=j;
                j++;
            }
        }
        chars[ind]=chars[i];
        ind++;
        if(j-i==1){
            return ind;
        }
        else if((j-i)<10){
            chars[ind]=(char)(j-i+'0');
        }
        else{                   
            String str = String.valueOf(j-i);
            for(char ch: str.toCharArray()){
                chars[ind]=ch;
                ind++;
            }
            return ind;
        }
        return ind+1;
    }
}