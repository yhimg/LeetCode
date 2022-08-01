class LRUCache {
    
    static class Node{
        int key, value;
        Node next, prev;
        Node(){
            key = -1;
            value = -1;
            next = null;
            prev = null;
        }
        
        Node(int key, int value){
            this.key = key;
            this.value = value;
            next = null;
            prev = null;
        }
    }

    
    int cacheSize;
    Map<Integer, Node> cache;
    Node head;
    Node tail;
    public LRUCache(int capacity) {
        cacheSize = capacity;
        cache = new HashMap();
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(cache.containsKey(key)){
            Node temp = cache.get(key);
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
            pushAtBegin(temp);
            cache.put(key, temp);
            return temp.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)){
            Node temp = cache.get(key);
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
            temp.value = value;
            pushAtBegin(temp);
            cache.put(key, temp);
        } else {
            if(cache.size()<cacheSize){
                Node temp = new Node(key, value);
                pushAtBegin(temp);
                cache.put(key, temp);
            } else{
                Node delete = deleteFromEnd();
                cache.remove(delete.key);
                Node temp = new Node(key, value);
                pushAtBegin(temp);
                cache.put(key, temp);
            }
        }
    }
    
    private void pushAtBegin(Node temp){
        temp.next = head.next;
        head.next = temp;
        temp.next.prev = temp;
        temp.prev = head;
    }
    
    private Node deleteFromEnd(){
        Node delete = tail.prev;
        tail.prev = tail.prev.prev;
        tail.prev.next = tail;
        delete.next = null;
        delete.prev = null;
        return delete;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */