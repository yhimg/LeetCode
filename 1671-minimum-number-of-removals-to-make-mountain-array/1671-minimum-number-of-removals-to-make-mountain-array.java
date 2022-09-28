class Solution {
    public int minimumMountainRemovals(int[] arr) {
        int n = arr.length;
        int dpInc[] = new int[n];
        int dpDec[] = new int[n];
        
        for(int i = 0; i<n; i++){
            dpInc[i] = 1;
            for(int j = 0; j<i; j++){
                if(arr[i] > arr[j])
                    dpInc[i] = Math.max(dpInc[i], 1+dpInc[j]);
            }
        }
       
        for(int i = n-1; i >=0; i--){
            dpDec[i] = 1;
            for(int j = n-1; j > i; j--){
                if(arr[i] > arr[j])
                    dpDec[i] = Math.max(dpDec[i], 1+dpDec[j]);
            }
        }
        
         int maxLen = 0;
        for(int i = 0; i<n; i++){
            if(dpDec[i] > 1 && dpInc[i] > 1)
                maxLen = Math.max(maxLen, dpInc[i]+dpDec[i] - 1);
        }
        // for(int x : dpInc) System.out.print(x + ", ");
        // System.out.println();
        // for(int x : dpDec) System.out.print(x + ", ");
        // System.out.println("\n" + maxLen + "--");
        return n-maxLen;
    }
}