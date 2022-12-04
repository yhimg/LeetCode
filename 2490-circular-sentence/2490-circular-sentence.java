class Solution {
    public boolean isCircularSentence(String str) {
        /*int n = str.length();
        if(str.charAt(0) != str.charAt(n-1)) return false;
        String[] arr = str.split(" ");
        for(int i = 0; i<arr.length-1; i++){
            int len = arr[i].length();
            if(arr[i].charAt(len-1) != arr[i+1].charAt(0)) return false;
        }
        return true;*/
        
        
        int n = str.length();
        if(str.charAt(0) != str.charAt(n-1)) return false;
        for(int i = 0; i < n; i++){
            if(str.charAt(i) == ' '){
                if(str.charAt(i-1) != str.charAt(i+1))
                    return false;
            }
        }
        return true;
    }
}