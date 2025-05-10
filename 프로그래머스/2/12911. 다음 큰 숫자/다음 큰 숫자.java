import java.util.*;

class Solution {
    public int solution(int n) {
        
        String s = Integer.toBinaryString(n);
        int cnt = s.replace("0", "").length();

        for (int i = n + 1; i < 2 * n; i++) {
            s = Integer.toBinaryString(i);
            if (cnt == s.replace("0", "").length()) return i;
        }
        
        return -1;
    }
}