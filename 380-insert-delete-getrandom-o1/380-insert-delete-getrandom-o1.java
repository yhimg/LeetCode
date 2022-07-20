class RandomizedSet {

    List<Integer> randomSet;
    public RandomizedSet() {
        randomSet = new ArrayList<Integer>();
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
        Random rand = new Random();
        return randomSet.get(rand.nextInt(randomSet.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */