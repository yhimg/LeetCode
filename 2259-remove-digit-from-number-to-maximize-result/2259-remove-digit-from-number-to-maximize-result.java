import java.math.BigInteger;
class Solution {
    public String removeDigit(String number, char digit) {
        String max = "0";
        String tempNumber = number;
        for(int i=0; i<tempNumber.length(); i++){
            if(tempNumber.charAt(i) == digit){
                String num = tempNumber.substring(0, i) + tempNumber.substring(i+1);
                if(new BigInteger(num).compareTo(new BigInteger(max)) > 0){
                    max = num;
                }
            }
        }
        return String.valueOf(max);
    }
}