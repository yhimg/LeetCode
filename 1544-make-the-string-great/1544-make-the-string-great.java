class Solution {
    public String makeGood(String s) {
        int len = s.length();
        if(len <= 1) return s;
        Stack<Character> stack = new Stack();
        stack.push(s.charAt(0));
        for(int i = 1; i<len; i++){
            if(stack.size() > 0 && Math.abs(s.charAt(i) - stack.peek()) == 32){
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}