class Solution {
    public int trap(int[] height) {
        int[] left = new int[height.length];
        int[] right = new int[height.length];
        int ans = 0;
        int leftMax = 0;
        for(int i=0; i< height.length; i++){
            leftMax = Math.max(leftMax, height[i]);
            left[i] = leftMax;
        }
        
        int rightMax = 0;
        for(int i = height.length-1; i>=0; i--){
            rightMax = Math.max(rightMax, height[i]);
            right[i] = rightMax;
        }
        
        for(int i=0; i<height.length; i++){
            ans += Math.min(left[i], right[i]) - height[i];
        }
        
        return ans;
        
        
    }
}