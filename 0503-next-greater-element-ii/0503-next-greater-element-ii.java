class Solution {
    public int[] nextGreaterElements(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        ArrayDeque<Integer> stack = new ArrayDeque();

        for (int i = 2 * n - 1; i >= 0; i--) {
      while (!stack.isEmpty() && stack.peek() <= arr[i % n]) {
        stack.pop();
      }

      if (i < n) {
        if (stack.isEmpty()) {
          ans[i] = -1;
        } else {
          ans[i] = stack.peek();
        }
      }

      stack.push(arr[i % n]);
    }
        return ans;
    }
}