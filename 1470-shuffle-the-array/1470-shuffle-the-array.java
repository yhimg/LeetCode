class Solution {
    public int[] shuffle(int[] arr, int n) {
//using i and j as two pointers in the given array
//and k is for the final array   
     int i=0,j=n,k=0;
         int[] ans=new int[arr.length];
    // run loop until i and j are beyound there limits 
   while(i<n||j<arr.length){
//if i pointer is at its last position then copy all the remaining elements uisng j 
       if(i>n){

          while(j<arr.length) {
              ans[k]=arr[j];
              j++;
              k++;
          }
              break;
       }
//if j pointer is at its last position then copy all the remaining elements uisng i
       if(j>arr.length){
           while(i<n ) {
               ans[k]=arr[i];
               i++;
               k++;
           }
          break;
       }
// add elements in the final array simultanously
       ans[k]=arr[i];
       k++;
       i++;
       ans[k]=arr[j];
       k++;
       j++;
   }
   return ans;
    }
}