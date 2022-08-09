class Solution {
    public List<List<String>> solveNQueens(int n) {
        String[][] board = new String[n][n];
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                board[i][j] = ".";
            }
        }
        List<List<String>> result = new ArrayList();
        solve(0, n, board, result);
        return result;
    }
    
    private void solve(int col, int n, String[][] board, List<List<String>> result){
        if(col < n){
            for(int i = 0; i<n; i++){
                if(isValidPos(i, col, n, board)){
                    board[i][col] = "Q";
                    solve(col+1, n, board, result);
                    board[i][col] = ".";
                }
            }
        } else{
            List<String> mid = new ArrayList();
            for(int i = 0; i<n; i++){
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j<n; j++){
                    sb.append(board[i][j]);
                }
                mid.add(sb.toString());
                
            }
            result.add(mid);
            return;
        }
    }
    
    private boolean isValidPos(int x, int y, int n, String[][] board){
        int i = x;
        int j = y;
        
        while(i >= 0 && j >= 0){
            if(board[i][j] == "Q") return false;
            i--;
            j--;
        }
        
        i=x;
        j=y;
        while(j >= 0){
            if(board[i][j] == "Q") return false;
            j--;
        }
        
        i=x;
        j=y;
        while(i < n && j >=0){
            if(board[i][j] == "Q") return false;
            i++;
            j--;
        }
        
        return true;
    }
}