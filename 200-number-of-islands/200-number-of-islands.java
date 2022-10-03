class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(grid[i][j] == '1'){
                    count++;
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
}