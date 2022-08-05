class Solution {
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap();
        for(int i=0; i<s.length(); i++){
            char curr = s.charAt(i);
            if(map.containsKey(curr)){
                map.put(curr, map.get(curr) + 1);
            } else{
                map.put(curr, 1);
            }
        }
        int index = -1;
        for(int i=0; i<s.length(); i++){
            char curr = s.charAt(i);
            if(map.get(curr) == 1){
                index = i;
                break;
            }
        }
        return index;
    }
}