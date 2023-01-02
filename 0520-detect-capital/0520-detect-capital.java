class Solution {
    public boolean detectCapitalUse(String str) {
        int len = str.length()-1;
        int i = len;
        if(isCapital(str.charAt(i--))){
            while(i >= 0){
                if(!isCapital(str.charAt(i))) return false;
                i--;
            }
            return true;
        }
        i = len-1;
        while(i > 0){
            if(isCapital(str.charAt(i))) return false;
            i--;
        }
        return true;
        
        
    }
    
    private boolean isCapital(char ch){
        if(ch >= 65 && ch <= 90) return true;
        return false;
    }
}