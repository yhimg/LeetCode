class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if(words.length != pattern.length()) return false;
        
        Map<Character, String> map1 = new HashMap();
        Map<String, Boolean> map2 = new HashMap();
        
        for(int i = 0; i<words.length; i++){
            char mapWith = pattern.charAt(i);
            if(map1.containsKey(mapWith)){
                String mWith = map1.get(mapWith);
                if(!mWith.equals(words[i])) return false;
            } else{
                if(map2.containsKey(words[i])) return false;
                map1.put(mapWith, words[i]);
                map2.put(words[i], true);
            }
            
            
            
            
            
//             if(map2.containsKey(words[i])){
//                 if(!map1.containsKey(mapWith)) return false;
//                 if(!map1.get(mapWith).equals(words[i])) return false;
                
//             } else{
//                 if(map1.containsKey(mapWith)) return false;
//                 map2.put(words[i], true);
//                 map1.put(mapWith, words[i]);
//             }
        }
        return true;
    }
}