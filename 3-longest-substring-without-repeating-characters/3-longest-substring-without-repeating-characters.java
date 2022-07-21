class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;
        int left = 0;
        int right = 0;
        Map<Character, Integer> map = new HashMap();
        
        int maxLen = 0; 
        while(right < s.length()){
            char currentChar = s.charAt(right);
            if(map.containsKey(currentChar)){
                int index = map.get(currentChar);
                left = Math.max(left, index+1);
            }
            map.put(currentChar, right);
            maxLen = Math.max(maxLen, (right-left+1));
            right++;
        }
        
        return maxLen;
    }
}