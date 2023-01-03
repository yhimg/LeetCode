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