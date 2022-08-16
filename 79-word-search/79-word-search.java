class Solution {
    public boolean exist(char[][] board, String word) {
        int[][] visited = new int[board.length][board[0].length];
        for(int i = 0; i<board.length; i++){
            for(int j = 0; j<board[i].length; j++){
                if(board[i][j] == word.charAt(0) && solve(i, j, board, board.length, board[i].length, word, visited, 0)){
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean solve(int row, int col, char[][] board, int m, int n, String word, int[][] visited, int index){
        if(index == word.length()) 
            return true;
        if(row >= m || col >= n || row < 0 || col < 0 || visited[row][col] == 1 || board[row][col] != word.charAt(index)) 
            return false;
        
        visited[row][col] = 1;
        boolean result = solve(row, col+1, board, m, n, word, visited, index+1) 
            || solve(row, col-1, board, m, n, word, visited, index+1)
            || solve(row+1, col, board, m, n, word, visited, index+1)
            || solve(row-1, col, board, m, n, word, visited, index+1);
        visited[row][col] = 0;
        return result;
        
    }
    
    
    
}