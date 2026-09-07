class Solution {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] result = new int[n];
        if (k == 0) {
            return result; 
        }
        int start = 1;
        int end = k;
        
        if (k < 0) {
            start = n + k;
            end = n - 1;
        }
        int Sum = 0;
        for (int i = start; i <= end; i++) {
            Sum += code[i];
        }
        for (int i = 0; i < n; i++) {
            result[i] = Sum;
            Sum -= code[start % n];
            Sum += code[(end + 1) % n];
            start++;
            end++;
        }
        
        return result;
    }
}
