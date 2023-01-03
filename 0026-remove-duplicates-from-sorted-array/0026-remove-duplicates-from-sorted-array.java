class Solution {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        int i = 0;
        int j = 0;
        while(j <len){
            if(nums[j] != nums[i]){
                nums[i+1] = nums[j];
                i++;
            }
            j++;
        }
        // for(int x = 0; x<len; x++){
        //     System.out.println(nums[x]);
        // }
        return i+1;
    }
}