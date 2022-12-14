class Solution {
   public int rob(int[] arr) {
       int n = arr.length;
       if(n == 1) return arr[0];
       int[] arr1 = new int[n-1];
       int[] arr2 = new int[n-1];
       for(int i = 0; i<n; i++){
           if(i != 0)
               arr1[i-1] = arr[i];
           if(i != n-1)
               arr2[i] = arr[i];
       }
       int prev = arr1[0];
       int prev2 = 0;
       int curr1 = 0;
       for(int i = 1; i<arr1.length; i++){
           int take = arr1[i];
           int notTake = 0;
           if(i > 1)
               take += prev2;
           notTake = prev;
           
           curr1 = Math.max(take, notTake);
           
           prev2 = prev;
           prev = curr1;
       }
       
       int prevN = arr2[0];
       prev2 = 0;
       int curr2 = 0;
       for(int i = 1; i<arr2.length; i++){
           int take = arr2[i];
           int notTake = 0;
           if(i > 1)
               take += prev2;
           notTake = prevN;
           
           curr2 = Math.max(take, notTake);
           
           prev2 = prevN;
           prevN = curr2;
       }
       return Math.max(prev, prevN);
       
    }
}