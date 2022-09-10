class Solution {
    public int minDistance(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();
        int dp[][] = new int[l1+1][l2+1];
        
        //int lcsLen = 0;
        for(int i = 1; i<=l1; i++){
            for(int j = 1; j<=l2; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                    //lcsLen = Math.max(lcsLen, dp[i][j]);
                }
                    
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        int lcsLen = dp[l1][l2];
        //System.out.println(lcsLen);
        return (s1.length() - lcsLen) + (s2.length() - lcsLen);
    }
}