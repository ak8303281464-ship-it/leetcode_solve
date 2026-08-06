class Solution {
    public int smallestNumber(int n, int t) {
        // Infinite loop to increment n until we find a match
        while (true) {
            if (getDigitProduct(n) % t == 0) {
                return n; 
            }
            n++; // Move to the next number if condition fails
        }
    }

    // Helper method to compute the product of digits safely
    private int getDigitProduct(int num) {
        int prod = 1;
        while (num > 0) {
            prod *= (num % 10);
            num /= 10;
        }
        return prod;
    }
}