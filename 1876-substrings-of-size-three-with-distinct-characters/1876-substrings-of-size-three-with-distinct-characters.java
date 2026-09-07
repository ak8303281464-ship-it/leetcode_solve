import java.util.HashMap;
class Solution {
    public int countGoodSubstrings(String s) {
        int count = 0;
        HashMap<Character, Integer> window = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char inChar = s.charAt(i);
            window.put(inChar, window.getOrDefault(inChar, 0) + 1);
            if (i >= 3) {
                char outChar = s.charAt(i - 3);
                window.put(outChar, window.get(outChar) - 1);
                if (window.get(outChar) == 0) {
                    window.remove(outChar);
                }
            }
            
                        if (window.size() == 3) {
                count++;
            }
        }
        
        return count;
    }
}
