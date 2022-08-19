class Solution {
    public String longestPalindrome(String s) {
        String res =  "";
        int len = 0;
        for(int i = 0; i< s.length(); i++){
            int l = i, r = i;
            while(l >=0 && r<s.length() && s.charAt(l) == s.charAt(r)){
                if(r-l+1 > len){
                    res = s.substring(l, r+1);;
                    len = r-l+1;
                } 
                l--;
                r++;
            }
            l = i; 
            r = i+1;
            while(l >=0 && r<s.length() && s.charAt(l) == s.charAt(r)){
                if(r-l+1 > len){
                    res = s.substring(l, r+1);;
                    len = r-l+1;
                } 
                l--;
                r++;
            }
        }
        return res;
        
        /*
        int len = 0;
        String ans = "";
        for(int i = 0; i<s.length(); i++){
            for(int j = i; j<s.length(); j++){
                if(palindromes.contains(s.substring(i, j+1)) || isPalindrome(s, i, j)){
                    String temp = s.substring(i, j+1);
                    
                    palindromes.add(ans);
                }
            }
        }
        return ans;*/
    }
    
    
}