class Solution {
    public int minDeletionSize(String[] strs) {
        int count = 0;
        if(strs == null || strs.length <= 1) return count;
        int columns = strs[0].length();
        for(int col = 0; col <columns; col++){
            for(int row = 1; row<strs.length; row++){
                String curr = strs[row];
                String prev = strs[row-1];
                if(curr.charAt(col) < prev.charAt(col)){
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}
// class Solution {
//     public int minDeletionSize(String[] A) {
//         int deleted = 0;
//         if (A == null || A.length == 0) return deleted;
//         int rowSize = A[0].length();
        
//         for (int col = 0; col < rowSize; col++){
//             if (!isSorted(A, col)) deleted++;
//         }
        
//         return deleted;
//     }
    
//     boolean isSorted(String[] A, int col){
//         int N = A.length;
//         char prev = (char)0;
//         for (int i = 0; i < N; i++){
//             char c = A[i].charAt(col);
//             //If out of order
//             if (c < prev) return false;
//             //update prev
//             prev = c;
//         }
        
//         return true; //In order the whole time
//     }
// }