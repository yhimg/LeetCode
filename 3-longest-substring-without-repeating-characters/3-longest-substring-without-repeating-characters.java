class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap();
        int i=0, j=0;
        int maxLen = 0;
        while(j<s.length()){
            if(map.containsKey(s.charAt(j))){
                i = Math.max(i, map.get(s.charAt(j))+1);
            }
            maxLen = Math.max(maxLen, j-i+1);
            map.put(s.charAt(j), j);
            j++;
        }
        return maxLen;
    }
}