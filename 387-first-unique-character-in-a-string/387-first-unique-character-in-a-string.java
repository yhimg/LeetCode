class Solution {
    public int firstUniqChar(String s) {
        
        for(int i=0; i<s.length(); i++){
            char curr = s.charAt(i);
            if(s.indexOf(curr) == s.lastIndexOf(curr))
                return i;
        }
        return -1;
        
        
        /*Map<Character, Integer> map = new HashMap();
        for(int i=0; i<s.length(); i++){
            char curr = s.charAt(i);
            if(map.containsKey(curr)){
                map.put(curr, map.get(curr) + 1);
            } else{
                map.put(curr, 1);
            }
        }
        for(int i=0; i<s.length(); i++){
            char curr = s.charAt(i);
            if(map.get(curr) == 1){
                return i;
            }
        }
        return -1;*/
    }
}