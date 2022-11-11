class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for(int j = 0; j<nums.length; j++, i++){
            nums[i] = nums[j];
            if(i > 0 && nums[i-1] == nums[i])
                i--;
        }
        
        return i;
    }
}