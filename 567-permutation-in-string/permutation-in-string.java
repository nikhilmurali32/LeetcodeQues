class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashSet<Character> uniqueS1 = new HashSet<>();
        int[] freq = new int[26];
        for(char ch:s1.toCharArray()){
            uniqueS1.add(ch);
            freq[ch-'a']++;
        }
        int i=0, j=0;
        while(i<=j && j<s2.length()){
            if(!uniqueS1.contains(s2.charAt(j))){
                if(i==j){
                    i++;
                    j++;
                }
                else{
                    while(i<j){
                        if(uniqueS1.contains(s2.charAt(i))){
                            freq[s2.charAt(i)-'a']++;
                        }
                        i++;
                    }
                    i++;
                    j++;
                }
            }
            else{
                if(freq[s2.charAt(j)-'a']==0){
                    while(i<j && freq[s2.charAt(j)-'a']<=0){
                        if(uniqueS1.contains(s2.charAt(i))){
                            freq[s2.charAt(i)-'a']++;
                        }
                        i++;
                    }                   
                }
                freq[s2.charAt(j)-'a']--;
                if(check(freq)){
                    return true;
                }
                j++;
            }
        }
        return false;
    }
    public boolean check(int[] arr){
        for(int i:arr){
            if(i!=0){
                return false;
            }
        }
        return true;
    }
}