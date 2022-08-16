class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i = 0; i<board.length; i++){
            for(int j = 0; j<board[i].length; j++){
                if(board[i][j] == word.charAt(0) && solve(i, j, board, board.length, board[i].length, word, 0)){
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean solve(int row, int col, char[][] board, int m, int n, String word,int index){
        if(index == word.length()) 
            return true;
        if(row >= m || col >= n || row < 0 || col < 0 || board[row][col] != word.charAt(index)) 
            return false;
        
        board[row][col] = '*';
        boolean result = solve(row, col+1, board, m, n, word, index+1) 
            || solve(row, col-1, board, m, n, word, index+1)
            || solve(row+1, col, board, m, n, word, index+1)
            || solve(row-1, col, board, m, n, word, index+1);
        board[row][col] = word.charAt(index);
        return result;
        
    }
    
    
    
}