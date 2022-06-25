class Solution {
    public String reverseOnlyLetters(String s) {
        char[] arr = s.toCharArray();
        int low = 0, high = arr.length-1;
        while(low<high){
            
            if(arr[low] < 65 ||(arr[low] > 90 && arr[low] < 97) || arr[low] > 122)
                low++;
            else {
                if(arr[high] < 65 ||(arr[high] > 90 && arr[high] < 97) || arr[high] > 122)
                    high--;
                else {
                    char temp = arr[low];
                    arr[low] = arr[high];
                    arr[high] = temp;
                    high--;
                    low++;
                }
            }
            
        }
        return String.valueOf(arr);
    }
}