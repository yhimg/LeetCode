class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap();
        for(int i = 0; i<s.length(); i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        List<Character> chars = new ArrayList(map.keySet());
        Collections.sort(chars, (a, b) -> map.get(b) - map.get(a));
        StringBuilder sb = new StringBuilder();
        for(char ch : chars){
            int i = 0;
            while(i < map.get(ch)){
                sb.append(ch);
                i++;
            }
                
        }
        return sb.toString();
//         int[] freq = new int[26];
//         for(int i = 0; i< s.length(); i++){
//             freq[s.charAt(i) - 'a']++;
//         }
//         for(int i = 0; i<26; i++){
//             System.out.println(i + "->" + freq[i]);
//         }
        
//         System.out.println(map);
//         Arrays.sort(freq);
//         return "";
        
    }
}