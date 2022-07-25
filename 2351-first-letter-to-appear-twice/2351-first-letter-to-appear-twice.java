class Solution {
    public char repeatedCharacter(String s) {
        /*Set<Character> set = new HashSet();
        for(int i =0; i<s.length(); i++){
            if(set.contains(s.charAt(i))) return s.charAt(i);
            set.add(s.charAt(i));
        }
        return 'x';*/
        
        /*int[] arr = new int[26];
        for(char c : s.toCharArray()){
            if(arr[c - 'a'] == 1) return c;
            arr[c-'a'] = 1;
        }
        return 'a';*/
        
        boolean[] arr = new boolean[26];
        for(char c : s.toCharArray()){
            if(arr[c - 'a'] == true) return c;
            arr[c-'a'] = true;
        }
        return 'a';
    }
}