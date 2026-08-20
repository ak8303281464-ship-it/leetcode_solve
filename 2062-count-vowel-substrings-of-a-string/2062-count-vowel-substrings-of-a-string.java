class Solution {
    public int countVowelSubstrings(String word) {
        int count = 0;
        int n = word.length();
        
        for (int i = 0; i < n; i++) {
            int mask = 0;
            for (int j = i; j < n; j++) {
                char ch = word.charAt(j);
                
                // Map vowels directly to bits, consonants evaluate to -1
                int bit = (ch == 'a') ? 1 : (ch == 'e') ? 2 : (ch == 'i') ? 4 : (ch == 'o') ? 8 : (ch == 'u') ? 16 : -1;
                
                if (bit == -1) break; // Terminate early on consonants
                
                mask |= bit;
                if (mask == 31) count++; // 31 represents all 5 bits set (1+2+4+8+16)
            }
        }
        return count;
    }
}