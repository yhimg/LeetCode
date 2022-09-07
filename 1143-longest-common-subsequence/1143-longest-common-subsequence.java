class Solution {
    public int longestCommonSubsequence(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        int[][] dp = new int[len1][len2];
        for(int i = 0; i<len1; i++)
            Arrays.fill(dp[i], -1);
        return solve(len1-1, len2-1, s1, s2, dp);
        
        /*for(int i = 0; i<len1; i++){
            if(s1.charAt(i) == s2.charAt(0)) return dp[i][0] = 1;
            
        }
        
        for(int j = 1; j< len2; j++){
            if(s1.charAt(0) == s2.charAt(j)) return dp[0][j] = 1;
        }
        
        for(int ind1 = 1; ind1<len1; ind1++){
            for(int ind2 = 1; ind2<len2; ind2++){
                int len = 0;
                if(s1.charAt(ind1) == s2.charAt(ind2)){
                    len = 1 + dp[ind1-1][ind2-1];
                } else{
                    len = Math.max(dp[ind1-1][ind2], dp[ind1][ind2-1]);
                }
                
                dp[ind1][ind2] = len;
            }
        }
        for(int i =0; i<len1; i++){
            System.out.println("Hello");
            for(int j = 0; j<len2; j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return dp[len1-1][len2-1];*/
        
    }
    
    
    private int solve(int ind1, int ind2, String s1, String s2, int[][] dp){
        if(ind1 < 0 || ind2 < 0) return 0;
        if(dp[ind1][ind2] != -1) return dp[ind1][ind2];
        /*if(ind1 == 0 || ind2 == 0){
            if(s1.charAt(ind1) == s2.charAt(ind2)) return 1;
        }*/
        int len = 0;
        if(s1.charAt(ind1) == s2.charAt(ind2)){
            return dp[ind1][ind2] = 1 + solve(ind1-1, ind2-1, s1, s2, dp);
        } else{
            return dp[ind1][ind2]=  Math.max(solve(ind1, ind2-1, s1, s2, dp), solve(ind1-1, ind2, s1, s2, dp));
        }
        
        //return dp[ind1][ind2] = len;
    }
}