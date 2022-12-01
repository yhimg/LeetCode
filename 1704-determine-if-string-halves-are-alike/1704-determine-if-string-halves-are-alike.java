class Solution {
    Character[] vow = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
    List<Character> vowels = Arrays.asList(vow);
    public boolean halvesAreAlike(String s) {
        int low = 0;
        int high = s.length()-1;
        int c1 = 0; 
        int c2 = 0;
        while(low<high){
            
            if(vowels.contains(s.charAt(low))){
                c1++;
            }
            if(vowels.contains(s.charAt(high))){
                c2++;
            }
            low++; 
            high--;
        }
        return c1 == c2;
    }
}