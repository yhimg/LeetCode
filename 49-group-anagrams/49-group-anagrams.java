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
          if(!result.containsKey(temp)) result.put(temp, new LinkedList<>());
          result.get(temp).add(strs[i]);
        }
        
        return new LinkedList<>(result.values());
    }
}