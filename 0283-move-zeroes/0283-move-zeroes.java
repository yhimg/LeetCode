class Solution {
    public void moveZeroes(int[] nums) {
        int len = nums.length;
        int i = 0; 
        int j = 0;
        // int arr[] = new int[len];
        // for(int i = 0; i<len; i++){
        //     if(nums[i] == 0){
        //         arr[high] = 0;
        //         high--;
        //     } else{
        //         arr[low] = nums[i];
        //         low++;
        //     }
        // }
        
        
        while(j < len){
            if(nums[j] != 0){
                nums[i] = nums[j];
                i++;
            }
            j++;
        }
        while(i < len){
            nums[i] = 0;
            i++;
        }
    }
}