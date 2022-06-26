class MedianFinder {

    private Queue<Integer> q1;
    private Queue<Integer> q2;
    public MedianFinder() {
        q1 = new PriorityQueue(Collections.reverseOrder());
        q2 = new PriorityQueue();
    }
    
    public void addNum(int num) {
        if(q1.isEmpty() || q1.peek() > num){
            q1.add(num);
        } else {
            q2.add(num);
        }
        if(q1.size() > q2.size()+1){
            q2.add(q1.poll());
        } else if(q2.size() > q1.size()+1){
            q1.add(q2.poll());
        }
        System.out.println("q1:" + q1.peek());
        System.out.println("q2:" + q2.peek());
    }
    
    public double findMedian() {
        System.out.println("--q1:" + q1.peek());
        System.out.println("--q2:" + q2.peek());
        if(q1.size() == q2.size()){
            return (q1.peek()+q2.peek())/2.0;
        }
        if(q1.size() > q2.size()){
            return q1.peek();
        } else {
            return q2.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */