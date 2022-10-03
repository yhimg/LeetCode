class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        int[][] visited = new int[m][n];
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                //if(grid[i][j] == '1' && visited[i][j] != 1){
                if(grid[i][j] == '1'){
                    // queue.add(new int[]{i, j});
                    // visited[i][j] = 1;
                    count++;
                    //bfs(visited, grid, m, n, queue);
                    //dfs1(i, j, visited, grid, m, n);
                    dfs2(i, j, grid);
                }
            }
        }
        return count;
    }
    private void dfs2(int i, int j, char[][] grid){
        if(i < 0 || j < 0 || i == grid.length || j == grid[0].length || grid[i][j] != '1')
            return;
        grid[i][j] = 0;
        dfs2(i, j+1, grid);
        dfs2(i+1, j, grid);
        dfs2(i, j-1, grid);
        dfs2(i-1, j, grid);
    }
    private void dfs1(int i, int j, int[][] visited, char[][] grid, int m, int n){
        if(i < 0 || j < 0 || i == m || j == n || grid[i][j] != '1' || visited[i][j] == 1)
            return;
        visited[i][j] = 1;
        dfs1(i, j+1, visited, grid, m, n);
        dfs1(i+1, j, visited, grid, m, n);
        dfs1(i, j-1, visited, grid, m, n);
        dfs1(i-1, j, visited, grid, m, n);
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