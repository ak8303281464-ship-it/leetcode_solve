class Solution {
    public int secondHighest(String s) {
       int max =-1;
       int secondMax = -1;
       for(int  i =0; i<s.length(); i++){
        char c = s.charAt(i);
        if(c >= '0' && c <= '9'){
            int digit = c -'0';
            if(digit>max){
                secondMax = max;
                max = digit;
            }
            else if (digit<max && digit > secondMax){
                secondMax = digit;
            }
        }

       } 
      return  secondMax;
    }
}