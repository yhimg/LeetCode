class Solution {
    public String addBinary(String a, String b) {
       StringBuilder output= new StringBuilder();
    	int len1 = a.length();
    	int len2 = b.length();
    	String greater, smaller;
    	if (len1>len2) {
    		greater = a;
    		smaller = b;
    	}
    	else {
    		greater = b;
    		smaller = a;
    	}
    	len1 = greater.length()-1;
    	len2 = smaller.length()-1;
    	String carry ="0";
    	//System.out.println(len1);
    	//System.out.println(len2);
    	while(true) {
           if(len2<0) {
        	   break;
           }
           if(greater.charAt(len1)==smaller.charAt(len2)) {
        	   output.append(carry);
        	   if(smaller.charAt(len2)=='1') {
        		   carry = "1";
        	   }
        	   else {
        		   carry = "0";
        	   }
           }
           else {
        	   if (carry.equals("0")) {
        		   output.append("1");
        		   carry = "0";
        	   }
        	   else {
        		   output.append("0");
        		   carry = "1";
        	   }
           }
           len1--;
           len2--;
    	}
    	for(int i=len1; i>=0; i-- ) {
    		if(greater.charAt(i)==carry.charAt(0)) {
    			output.append("0");
    		}
    		else {
    			output.append("1");
    			carry = "0";
    		}
    	}
    	if(carry.equals("1")) {
    		output.append("1");
    	}
        return output.reverse().toString();
    }	
    
}