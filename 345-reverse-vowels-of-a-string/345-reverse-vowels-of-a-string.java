class Solution {
    public String reverseVowels(String s) {
        char[] arr = s.toCharArray();
        int l = 0, h = arr.length-1;
        
        while(l<h){
            while(!isVowel(arr[l]) && l<h) l++;
            while(!isVowel(arr[h]) && h>l) h--;
            if(l>=h) break;
            char temp = arr[l];
            arr[l] = arr[h];
            arr[h] = temp;
            l++;
            h--;
        }
        return new String(arr);
    }
    
    private boolean isVowel(char ch){
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ||
                ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') return true;
        return false;
    }
}