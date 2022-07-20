class RandomizedSet {

    Set<Integer> randomSet;
    public RandomizedSet() {
        randomSet = new HashSet<Integer>();
    }
    
    public boolean insert(int val) {
        if(randomSet.contains(val)) return false;
        randomSet.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if(randomSet.contains(val)){
            randomSet.remove(Integer.valueOf(val));
            return true;
        }
        return false;
    }
    
    public int getRandom() {
         
        int index = new Random().nextInt(randomSet.size());
        Iterator<Integer> iter = randomSet.iterator();
        for (int i = 0; i < index; i++) {
            iter.next();
        }
        return iter.next();
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */