class Solution {
    public int maxProfit(int[] arr) {
        if(arr == null || arr.length == 0) return 0;
        int min = arr[0];
        int profit = 0;
        for(int i = 1; i< arr.length; i++){
            profit = Math.max(arr[i] - min, profit);
            min = Math.min(arr[i], min);
        }
        return profit;
    }
}