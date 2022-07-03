class Solution {
    public String decodeMessage(String key, String message) {
        Map<Character, Character> table = new HashMap<>();
        char ch = 'a';
        for(int i=0; i< key.length(); i++){
            if(key.charAt(i) != ' ' && !table.containsKey(key.charAt(i))){
                table.put(key.charAt(i), ch++);
            }
        }
        StringBuffer result = new StringBuffer("");
        for(int i=0; i<message.length(); i++){
            if(message.charAt(i) != ' '){
                result.append(table.get(message.charAt(i)));
            } else{
                result.append(" ");
            }
        }
        return result.toString();
    }
}