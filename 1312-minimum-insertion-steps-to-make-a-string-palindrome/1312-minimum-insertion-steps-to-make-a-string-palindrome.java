class Solution {
    public int minInsertions(String s) {
        int[] len = new int[s.length()];
        char[] charArr = s.toCharArray();
        len[0] =1;
        int maxVal = 1;
        for(int i=1;i<charArr.length;i++){
            len[i]=1;
            int max = 0;
            for(int j =i-1;j>=0;j--){
                if(charArr[i] != charArr[j]){
                    max = Math.max(len[j],max);
                    continue;
                }
                int val = max +2;
                max = Math.max(len[j],max);
                maxVal = Math.max(maxVal,val);
                len[j]=val;
            }
        }
        return s.length() - maxVal;
    }
}