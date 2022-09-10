class Solution {
    public int minDistance(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();
        if (l1 < l2) {
            String tempStr = s1;
            s1 = s2;
            s2 = tempStr;
            int tempInt = l2;
            l2 = l1;
            l1 = tempInt;
        }
        int prev[] = new int[l2+1];
        
        //int lcsLen = 0;
        for(int i = 1; i<=l1; i++){
            int[] curr = new int[l2+1];
            for(int j = 1; j<=l2; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    curr[j] = 1 + prev[j-1];
                }
                else
                    curr[j] = Math.max(prev[j], curr[j-1]);
            }
            prev = curr;
        }
        int lcsLen = prev[l2];
        return (s1.length() - lcsLen) + (s2.length() - lcsLen);
    }
}