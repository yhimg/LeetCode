class Solution {
    public int minInsertions(String s1) {
        String s2 = new StringBuilder(s1).reverse().toString();
        int n = s1.length();
        
        int prev[] = new int[n+1];
        
        int len = 0;
        
        for(int i = 1; i<=n; i++){
            int[] curr = new int[n+1];
            for(int j = 1; j<=n; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    curr[j] = 1 + prev[j-1];
                    len = Math.max(len, curr[j]);
                } else{
                    curr[j] = Math.max(prev[j], curr[j-1]);
                }
            }
            prev = curr;
        }
        
        return n-len;
        
    }
}