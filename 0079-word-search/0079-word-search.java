class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        int visited[][] = new int[m][n];
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(board[i][j] == word.charAt(0) && solve(i, j, word, board, visited, 0)) return true;
            }
        }
        return false;
    }
    
    private boolean solve(int row, int col, String word, char[][] board, int[][] visited, int index){
        if(index == word.length()) return true;
        if(row<0 || row==board.length || col<0 || col==board[0].length || visited[row][col] == 1 || board[row][col] != word.charAt(index))
            return false;
        visited[row][col] = 1;
        //System.out.println(result);
        boolean ans = solve(row+1, col, word, board, visited, index+1)
            || solve(row-1, col, word, board, visited, index+1)
            || solve(row, col+1, word, board, visited, index+1)
            || solve(row, col-1, word, board, visited, index+1);
        visited[row][col] = 0;
        return ans;
    }
}