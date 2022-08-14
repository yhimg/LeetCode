class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }
    
    private boolean solve(char[][] board){
        for(int row = 0; row<9; row++){
            for(int col = 0; col < 9; col++){
                if(board[row][col] == '.'){
                    for(char i = '1'; i<='9'; i++){
                        if(isValidPos(board, row, col, i)){
                            board[row][col] = i;
                            if(solve(board)){
                                return true;
                            }
                            board[row][col] = '.';
                        } 
                    }
                    return false;
                } 
            }
        }
        return true;
    }
    
    
    private boolean isValidPos(char[][] board, int x, int y, char n){
        int row = x;
        int col = y;
        for(int j = 0; j<9; j++){
            if(board[row][j] == n) return false;
            if(board[j][col] == n) return false;
            int newX = x-x%3;
            int newY = y-y%3;
            if(!isValidInnerPos(board, newX, newY, n)) return false;
        }
        
        return true;
        
    }
    
    private boolean isValidInnerPos(char[][] board, int x, int y, char c){
        
        for(int m = x; m < x+3; m++){
            for(int n = y; n< y+3; n++){
                if(board[m][n] == c) return false;
            }
        }
        return true;
    }
}