class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc] == color) return image;
        solve(sr, sc, image, color, image[sr][sc]);
        return image;
    }
    
    private void solve(int row, int col, int[][] image, int newColor, int oldColor){
        if(row < 0 || col < 0 || row == image.length || col == image[0].length || image[row][col] != oldColor){
            return;
        }
        image[row][col] = newColor;
        solve(row, col+1, image, newColor, oldColor);
        solve(row, col-1, image, newColor, oldColor);
        solve(row+1, col, image, newColor, oldColor);
        solve(row-1, col, image, newColor, oldColor);
    }
}