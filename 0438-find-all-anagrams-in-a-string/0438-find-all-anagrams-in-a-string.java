import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s == null || p == null || s.length() < p.length()) {
            return result;
        }

        int[] pCount = new int[26];
        int[] sCount = new int[26];
        for (int i = 0; i < p.length(); i++) {
            pCount[p.charAt(i) - 'a']++;
        }

        int windowSize = p.length();
        for (int i = 0; i < s.length(); i++) {
           
            sCount[s.charAt(i) - 'a']++;
            if (i >= windowSize) {
                sCount[s.charAt(i - windowSize) - 'a']--;
            }
            if (matches(pCount, sCount)) {
                result.add(i - windowSize + 1);
            }
        }

        return result;
    }

    private boolean matches(int[] pCount, int[] sCount) {
        for (int i = 0; i < 26; i++) {
            if (pCount[i] != sCount[i]) {
                return false;
            }
        }
        return true;
    }
}
