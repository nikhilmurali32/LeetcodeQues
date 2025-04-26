class Solution {
    public int longestPalindrome(String s) {
        // HashMap<Character, Integer> hmap = new HashMap<>();
        // for(char c: s.toCharArray()){
        //     hmap.put()
        // }
        if(s.length()==1){
            return 1;
        }
        char[] c_arr = s.toCharArray();
        Arrays.sort(c_arr);
        int i=0;
        if(c_arr[i]==c_arr[s.length()-1]){
            return s.length();
        }
        int odd=0;
        int count=0;
        while(i<s.length()-1){
            if(c_arr[i]!=c_arr[i+1]){
                if(odd==0){
                    odd=1;
                }
                i++;
            }
            else{
                count += 2;
                i += 2;
            }
        }
        if(i==s.length()-1){
            odd=1;
        }
        // if(c_arr[s.length()-1])
        return odd==1?count+1:count;
    }
}