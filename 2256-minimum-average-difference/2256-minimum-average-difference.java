class Solution {
    public int minimumAverageDifference(int[] nums) {
        int n = nums.length;
        long total = 0;
        int minAvg = Integer.MAX_VALUE;
        int ans = -1;
        for(int num : nums){
            total += num;
        }
        long leftSum = 0;
        for(int i = 0; i<n; i++){
            leftSum += nums[i];
            
            long leftAvg = leftSum;
            leftAvg /= (i+1);
            
            long rightAvg = total - leftSum;
            if(i != n-1){
                rightAvg /= (n-i-1);
            }
            
            int diff = (int)Math.abs(leftAvg-rightAvg);
            
            if(diff < minAvg){
                minAvg = diff;
                ans = i;
            }
        }
        return ans;
    }
}