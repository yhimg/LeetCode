class Solution {
    public int removeElement(int[] nums, int val) {
        int len = nums.length;
        int i = 0, j= 0;
        while(j<len){
            if(nums[j] != val){
                if(j > i){
                    nums[i] = nums[j];
                }
                i++;
            }
            j++;
        }
        return i;
    }
}