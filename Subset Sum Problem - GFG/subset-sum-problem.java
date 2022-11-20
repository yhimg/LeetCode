//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            int sum = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            if(ob.isSubsetSum(N, arr, sum))
            System.out.println(1);
            else
            System.out.println(0);

            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{


    static Boolean isSubsetSum(int N, int arr[], int sum){
        // code here
        int dp[][] = new int[N+1][sum+1];
        for(int i = 0; i<=N; i++){
            Arrays.fill(dp[i], -1);
        }
        return solve(arr, N-1, sum, dp);
    }
    
    private static boolean solve(int[] arr, int n, int sum, int[][] dp){
    if(sum == 0) return true;
    else if(n == 0) return sum == arr[0];
    if(dp[n][sum] != -1) return dp[n][sum] == 1;
    boolean notTake = solve(arr, n-1, sum, dp);;
    boolean take = false;
    if(arr[n] <= sum){
      take = solve(arr, n-1, sum-arr[n], dp);
      dp[n][sum] = notTake || take ? 1 : 0;
    }

    return take || notTake;
  }
}