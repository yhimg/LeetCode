class Solution {
    public int lengthOfLongestSubstring(String s) {
        int size = s.length() - 1;
        Map<Character, Integer> map = new HashMap();
        int i = 0;
        int len = 0;
        int j = 0;
        
        while(j <= size){
            if(map.containsKey(s.charAt(j))){
                i = Math.max(i, map.get(s.charAt(j))+1);
            }
            len = Math.max(len, j-i+1);
            map.put(s.charAt(j), j);
            j++;
        }
        return len;
    }
}