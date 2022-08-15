class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList();
        //solve(s, result, new ArrayList());
        solve(s, 0, result, new ArrayList());
        return result;
    }
    
    /*private void solve(String s, List<List<String>> result, List<String> mid){
        if(0 == s.length()){
            result.add(new ArrayList(mid));
            return;
        }
        
        String temp = "";
        for(int i = 0; i<s.length(); i++){
           temp = s.substring(0, i+1);
            if(isPalindrome(temp)){
                mid.add(temp);
                solve(s.substring(i+1), result, mid);
                mid.remove(mid.size()-1);  
                temp = temp.substring(0, temp.length()-1);
            } 
        }
        
    }*/
    
    private void solve(String s, int index, List<List<String>> result, List<String> mid){
        if(index == s.length()){
            result.add(new ArrayList(mid));
            return;
        }
        
        for(int i = index; i<s.length(); i++){
           String temp = s.substring(index, i+1);
            if(isPalindrome(temp)){
                mid.add(temp);
                solve(s, i+1, result, mid);
                mid.remove(mid.size()-1);  
                temp = temp.substring(0, temp.length()-1);
            } 
        }
        
    }
    
    
    private boolean isPalindrome(String s){
        if(s.length() == 1) return true;
        int low = 0;
        int high = s.length()-1;
        while(low<high){
            if(s.charAt(low) != s.charAt(high)) return false;
            low++;
            high--;
        }
        return true;
    }
    
    
}