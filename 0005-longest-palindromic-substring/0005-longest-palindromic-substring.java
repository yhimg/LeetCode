class Solution {
    public String longestPalindrome(String s1) {
        String res = "";
        int resLen = 0;
        int l = 0; 
        int r = 0;
        for(int i = 0; i<s1.length(); i++){
            l = i;
            r = i;
            while(l >=0 && r<s1.length() && s1.charAt(l) == s1.charAt(r)){
                if((r-l+1) > resLen){
                    res = s1.substring(l, r+1);
                    resLen = r-l+1;
                }
                l--;
                r++;
            }
            l = i; 
            r = i+1;
            while(l >=0 && r < s1.length() && s1.charAt(l) == s1.charAt(r)){
                if(r-l+1 > resLen){
                    res = s1.substring(l, r+1);
                    resLen = r-l+1;
                }
                l--;
                r++;
            }
        }
        
        return res;

     }
    
     
}









//     String s2 = new StringBuilder(s1).reverse().toString();
//     int m = s1.length();
//     int n = s2.length();
//     int max = Integer.MIN_VALUE;
//     int maxi = -1;
//     int maxj = -1;
//     int[][] dp = new int[m+1][n+1];
//     for(int i = 1; i<=m; i++){
//       for(int j = 1; j<=n; j++){
//         if(s1.charAt(i-1) == s2.charAt(j-1))
//           dp[i][j] = 1+ dp[i-1][j-1];
//         if(dp[i][j] > max){
//           max = dp[i][j];
//           maxi = i;
//           maxj = j;
//         }
//       }
//     }

//     StringBuilder sb = new StringBuilder();
//     while(maxi>0 && maxj>0){
//       if(s1.charAt(maxi-1) == s2.charAt(maxj-1)){
//         sb.append(s1.charAt(maxi-1));
//       }
//       maxi--;
//       maxj--;
//     }

//     // for(int i = 0; i<=m; i++){
//     //   for (int j = 0; j <=n; j++) {
//     //     System.out.print(dp[i][j] + ", ");
//     //   }
//     //   System.out.println();
//     // }


//     return sb.reverse().toString();