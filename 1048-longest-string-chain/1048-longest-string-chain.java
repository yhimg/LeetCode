class Solution {
    public int longestStrChain(String[] arr) {
        Arrays.sort(arr, Comparator.comparingInt(String::length));
        int n = arr.length;
        int dp[] = new int[n];
        for(int i = 0; i<n; i++)
            Arrays.fill(dp, 1);
        int max = 1;
        for(int i = 1; i<n; i++){
            for(int j = 0; j<i; j++){
                if(isValid(arr[i], arr[j]))
                    dp[i] = Math.max(1+dp[j], dp[i]); 
            }
            max = Math.max(dp[i], max);
        }
        //for(String x : arr) System.out.print(x+ ", ");
        //System.out.println();
        for(int x : dp) System.out.print(x+ ", ");
        return max;
    }
    
    private boolean isValid(String curr, String prev){
        if(curr.length() - prev.length() != 1) return false;
        int i = 0, j = 0;
        int skip = 0;
        while(i < curr.length()){
            if(j < prev.length() && curr.charAt(i) == prev.charAt(j)){
                i++;
                j++;
            }else{
                i++;
            }
            // i++;
            // j++;
            // if(skip > 1) return false;
        }
        // while(i < curr.length()){
        //     skip++;
        //     i++;
        // }
        // if(j < prev.length()){ 
        //     skip++;
        //     j++;
        // }
        if(i == curr.length() && j == prev.length()) return true;
        return false;
        //return skip == 1;
    }
    
    
    
}