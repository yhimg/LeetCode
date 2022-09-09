class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        
        int prev[] = new int[len2+1];
        int max = 0;
        for(int i = 1; i<=len1; i++){
            int[] curr = new int[len2+1];
            for(int j = 1; j<=len2; j++){
                if(nums1[i-1] == nums2[j-1]){
                    curr[j] = 1 + prev[j-1];
                    max = Math.max(max, curr[j]);
                }
            }
            prev = curr;
        }
        return max;
    }
}