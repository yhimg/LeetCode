class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        ArrayDeque<int[]> q = new ArrayDeque();
        int visited[][] = new int[m][n];
        int count = -1;
        int fresh = 0;
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(grid[i][j] == 1) fresh++;
                else if(grid[i][j] == 2){
                    visited[i][j] = 2;
                    q.add(new int[]{i, j});
                    
                }
            }
        }
        if(fresh == 0) return 0;
        int[][] dirn = {{0,1}, {-1, 0}, {0, -1}, {1, 0}};
        while(!q.isEmpty()){
            int size = q.size();
            count++;
            for(int s = 0; s<size; s++){
                int[] curr = q.remove();
                for(int[] dir : dirn){
                    int i = curr[0] + dir[0];
                    int j = curr[1] + dir[1];
                    if(i>= 0 && i<grid.length && j>=0 && j<grid[0].length && grid[i][j] == 1){
                        grid[i][j] = 2;
                        q.add(new int[] {i, j});
                        fresh--;
                    }
                }
            }
        }
        return fresh == 0 ? count : -1;
    }
    
}