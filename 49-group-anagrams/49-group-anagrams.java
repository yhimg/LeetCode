class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> finalR = new ArrayList<>();
        Map<String, List<String>> result = new HashMap<>();
        int len = strs.length;
        for(int i=0 ;i<len; i++){
          String temp = strs[i];
          char[] mid = temp.toCharArray();
          Arrays.sort(mid);
          temp = new String(mid);
          if(result.containsKey(temp)){
            List<String> val = result.get(temp);
            val.add(strs[i]);
            result.put(temp, val);
          } else{
            List<String> val = new ArrayList<>();
            val.add(strs[i]);
            result.put(temp, val);
          }
        }
        for(String key : result.keySet()){
          finalR.add(result.get(key));
        }
        return finalR;
    }
}