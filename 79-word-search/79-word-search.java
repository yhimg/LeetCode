class Solution {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        
        boolean [][] visited = new boolean[rows][cols];
        for(int i = 0; i<board.length; i++){
            for(int j = 0; j<board[0].length; j++){
                if(board[i][j] == word.charAt(0) && solve(i, j, board, visited, word, 0)) return true;
            }
        }
        
        return false;
    }
    
    
    private boolean solve(int row, int col, char[][] board, boolean[][] visited, String word, int index){
        if(word.length() == index){
            return true;
        }
        if(row == board.length || col == board[0].length || row < 0 || col < 0 || visited[row][col] || board[row][col] != word.charAt(index)){
            return false;
        }
        
        visited[row][col] = true;
        boolean result = solve(row, col+1, board, visited, word, index+1) 
            || solve(row, col-1, board, visited, word, index+1) 
            || solve(row+1, col, board, visited, word, index+1) 
            || solve(row-1, col, board, visited, word, index+1);
        visited[row][col] = false;
        return result;
    }
}