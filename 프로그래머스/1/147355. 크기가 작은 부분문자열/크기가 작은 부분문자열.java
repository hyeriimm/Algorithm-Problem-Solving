import java.util.*;

class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        long pn = Long.parseLong(p);
        
        for (int i = 0; i < t.length() - p.length() + 1; i++) {
            
            if (pn >= Long.parseLong(t.substring(i, i + p.length()))) 
                answer++;
        }
        
        return answer;
    }
}