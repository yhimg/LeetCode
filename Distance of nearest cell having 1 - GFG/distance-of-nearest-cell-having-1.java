//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] grid = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int[][] ans = obj.nearest(grid);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


class Solution
{
    //Function to find distance of nearest 1 in the grid for each cell.
    public int[][] nearest(int[][] grid)
    {
        // Code here
        int n = grid.length;
        int m = grid[0].length;
        int[][] visited = new int[n][m];
        int[][] result = new int[n][m];
        ArrayDeque<int[]> queue = new ArrayDeque<int[]>();
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(grid[i][j] == 1){
                    queue.add(new int[]{i, j, 0});
                    visited[i][j] = 1;
                    result[i][j] = 0;
                }
            }
        }
        int dirn[][] = {{0,1}, {0, -1}, {1, 0}, {-1, 0}};
        while(!queue.isEmpty()){
            int curr[] = queue.pop();
            if(grid[curr[0]][curr[1]] == 0){
                result[curr[0]][curr[1]] = curr[2];
            }
            for(int[] dir : dirn){
                int x = curr[0] + dir[0];
                int y = curr[1] + dir[1];
                if(x>=0 && x<n && y >= 0 && y<m && visited[x][y] != 1){
                    visited[x][y] = 1;
                    queue.add(new int[]{x,y,curr[2]+1});
                }
            }
        }
        return result;
    }
}