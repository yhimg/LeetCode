class Solution {
    public boolean closeStrings(String word1, String word2) {
        if(word1.length() != word2.length()) 
            return false;
        int[] cset1 = new int[26];
        int[] cset2 = new int[26];
        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];
        
        for(int i = 0; i<word1.length(); i++){
            cset1[word1.charAt(i) - 'a'] = 1;
            cnt1[word1.charAt(i) - 'a']++;
        }
        
        for(int i = 0; i<word2.length(); i++){
            cset2[word2.charAt(i) - 'a'] = 1;
            cnt2[word2.charAt(i) - 'a']++;
        }
        Arrays.sort(cnt1);
        Arrays.sort(cnt2);
        return Arrays.equals(cset1, cset2) && Arrays.equals(cnt1, cnt2);
    }
}