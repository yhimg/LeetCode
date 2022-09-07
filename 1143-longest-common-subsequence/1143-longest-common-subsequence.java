class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        int[][] dp = new int[len1][len2];
        for(int i = 0; i<len1; i++)
            Arrays.fill(dp[i], -1);
        return solve(len1-1, len2-1, text1, text2, dp);
    }
    
    
    private int solve(int ind1, int ind2, String s1, String s2, int[][] dp){
        if(ind1 < 0 || ind2 < 0) return 0;
        if(dp[ind1][ind2] != -1) return dp[ind1][ind2];
        if(ind1 == 0 || ind2 == 0){
            if(s1.charAt(ind1) == s2.charAt(ind2)) return 1;
        }
        int len = 0;
        int max = 0;
        if(s1.charAt(ind1) == s2.charAt(ind2)){
            len += 1 + solve(ind1-1, ind2-1, s1, s2, dp);
        } else{
            max =  Math.max(solve(ind1, ind2-1, s1, s2, dp), solve(ind1-1, ind2, s1, s2, dp));
        }
        
        return dp[ind1][ind2] = len+max;
    }
}