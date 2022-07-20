class RandomizedSet {

    List<Integer> randomSet;
    Map<Integer, Integer> map;
    Random rand = new Random();
    public RandomizedSet() {
        randomSet = new ArrayList<Integer>();
        map = new HashMap();
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val)) return false;
        map.put(val, randomSet.size());
        randomSet.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val)) return false;
        int index = map.get(val);
        int size = randomSet.size();
        randomSet.set(index, randomSet.get(size-1));
        map.put(randomSet.get(index), index);
        randomSet.remove(size-1);
        map.remove(val);
        return true;
    }
    
    public int getRandom() {
         
        return randomSet.get(rand.nextInt(map.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */