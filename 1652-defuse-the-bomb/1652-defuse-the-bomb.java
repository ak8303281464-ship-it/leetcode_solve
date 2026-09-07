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
        int windowSum = 0;
        for (int i = start; i <= end; i++) {
            windowSum += code[i];
        }
        for (int i = 0; i < n; i++) {
            result[i] = windowSum;
            windowSum -= code[start % n];
            windowSum += code[(end + 1) % n];
            start++;
            end++;
        }
        
        return result;
    }
}
