class Solution {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        Map<Integer, Integer> map = new TreeMap();
        for(int i = 0; i<items1.length; i++){
            map.put(items1[i][0], items1[i][1]);
        }
        for(int i = 0; i<items2.length; i++){
            if(map.containsKey(items2[i][0])){
                map.put(items2[i][0], map.get(items2[i][0])+items2[i][1]);
            } else map.put(items2[i][0], items2[i][1]);
        }
        List<List<Integer>> result = new ArrayList();
        Iterator itr = map.keySet().iterator();
        while(itr.hasNext()){
            int key = (int) itr.next();
            result.add(Arrays.asList(key, map.get(key)));
        }
        return result;
    }
}