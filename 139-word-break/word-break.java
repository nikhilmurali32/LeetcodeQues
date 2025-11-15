class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n=s.length();
        int i=0;
        boolean[] dp = new boolean[n+1];
        dp[0]=false;
        String str="";
        while(i<n){
            str += s.charAt(i);
            if(wordDict.contains(str)){
                dp[i+1]=true;
            }
            else{
                int j=i;
                String temp = "";
                int seen=0;
                while(j>=0){
                    temp = s.charAt(j)+temp;
                    if(wordDict.contains(temp) && dp[j]){
                        // dp[i]=true;
                        seen=1;
                        break;
                    }
                    j--;
                }
                if(seen==1){
                    dp[i+1]=true;
                }
                else{
                    dp[i+1]=false;
                }
            }
            System.out.println(str);
            System.out.println(dp[i]);
            i++;            
        }
        return dp[n];
    }
}