class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        int[][] visited = new int[m][n];
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(grid[i][j] == '1' && visited[i][j] != 1){
                    // queue.add(new int[]{i, j});
                    // visited[i][j] = 1;
                    count++;
                    //bfs(visited, grid, m, n, queue);
                    dfs(i, j, visited, grid, m, n);
                }
            }
        }
        // for(int i = 0; i<m; i++){
        //     for(int j = 0; j<n; j++){
        //         System.out.print(visited[i][j] + ", ");
        //     }
        //     System.out.println();
        // }
        return count;
    }
    
    private void dfs(int i, int j, int[][] visited, char[][] grid, int m, int n){
        if(i < 0 || j < 0 || i == m || j == n || grid[i][j] != '1' || visited[i][j] == 1)
            return;
        visited[i][j] = 1;
        dfs(i, j+1, visited, grid, m, n);
        dfs(i+1, j, visited, grid, m, n);
        dfs(i, j-1, visited, grid, m, n);
        dfs(i-1, j, visited, grid, m, n);
    }
    
    private void bfs(int[][] visited, char[][] grid, int m, int n, ArrayDeque<int[]> queue){
        int[][] dirn = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            for(int[] dir : dirn){
                int ni = curr[0] + dir[0];
                int nj = curr[1] + dir[1];
                if(ni >= 0 && nj >= 0 && ni < m && nj < n && grid[ni][nj] == '1' && visited[ni][nj] != 1) {
                    queue.addLast(new int[]{ni, nj});
                    visited[ni][nj] = 1;
                }
            }
        }
    }
}