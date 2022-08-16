class Solution {
    String[] mapping = {"0","1", "abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList();
        if(digits.length() == 0) return result;
        solve(0, digits, result, "");
        return result;
    }
    
    private void solve(int index, String digits, List<String> result, String sb){
        if(sb.length() == digits.length()){
            result.add(sb.toString());
            return;
        }
        
        String map = mapping[digits.charAt(index) - '0'];
        for(char c: map.toCharArray()){
            
            solve(index+1, digits, result, sb+c);
        }
    }
    
}