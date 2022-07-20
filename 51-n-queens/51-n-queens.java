class Solution {
    public List<List<String>> solveNQueens(int n) {
       String[][] board = new String[n][n];
        for(int i = 0; i<n; i++){
            for(int j=0; j<n; j++){
                board[i][j] = ".";
            }
        }
        //solve(0, n, result);
        
        List<List<String>> result = new ArrayList();
        int[] leftCol = new int[n];
        int[] lowerDiag = new int[2*(n)-1];
        int[] upperDiag = new int[2*(n)-1];
        solve(0, n, board, result, leftCol, lowerDiag, upperDiag);
        
        
        return result;
    }
    
    private void solve(int col, int n, String[][] board, List<List<String>> result,
                      int[] leftCol, int[] lowerDiag, int[] upperDiag){
        if(col >= n){
            
            List<String> mid = new ArrayList();
            
            for(int i = 0; i<n; i++){
                StringBuilder builder = new StringBuilder();
                for(int j=0; j<n; j++){
                    builder.append(board[i][j]);
                }
                mid.add(builder.toString());
            }
            result.add(new ArrayList(mid));
            
        
            return;
        }
        
        for(int row = 0; row < n; row++){
            //if(validPlace(row, col, board, n)){
            if(leftCol[row] == 0 && lowerDiag[row+col] == 0 && upperDiag[n-1+col-row] == 0){
                board[row][col] = "Q";
                leftCol[row] = 1;
                lowerDiag[row+col] = 1;
                upperDiag[n-1+col-row] = 1;
                solve(col+1, n, board, result, leftCol, lowerDiag, upperDiag);
                board[row][col] = ".";
                leftCol[row] = 0;
                lowerDiag[row+col] = 0;
                upperDiag[n-1+col-row] = 0;
            }
        }
    }
    
    
    private boolean validPlace(int row, int col, String[][] board, int n){
        int tempRow = row;
        int tempCol = col;
         while(tempRow >=0 && tempCol >=0){
             if(board[tempRow][tempCol] == "Q") return false;
             tempRow--;
             tempCol--;
         }
        tempRow = row;
        tempCol = col;
        
        while(tempCol >=0 ){
            if(board[tempRow][tempCol] == "Q") return false;
            tempCol--;
        }
        tempCol = col;
        while(tempRow <n && tempCol >=0){
             if(board[tempRow][tempCol] == "Q") return false;
             tempRow++;
             tempCol--;
         }
        return true;
    }
}