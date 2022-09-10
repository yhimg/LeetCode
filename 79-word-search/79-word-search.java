class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        boolean isValid = false;
        for(int i = 0; i < board.length; i++){
            for(int j=0; j<board[0].length; j++){
                isValid = solve(i, j, word, board, 0, visited);
                //System.out.println(isValid);                
                if(isValid) return true;;
            }
        }
        return isValid;
    }
    
    private boolean solve(int row, int col, String word, char[][] board, int index, boolean[][] visited){
        //System.out.println(curr);
        if(index == word.length()) return true;
        
        if(row<0 || col<0 || row >= board.length || col>= board[0].length || visited[row][col] || board[row][col] != word.charAt(index))
            return false;
        visited[row][col] = true;
        boolean result = solve(row, col+1, word, board, index+1, visited)
            || solve(row+1, col, word, board, index+1, visited)
            || solve(row, col-1, word, board, index+1, visited)
            || solve(row-1, col, word, board, index+1, visited);
        visited[row][col] = false;
        return result;
    }
}