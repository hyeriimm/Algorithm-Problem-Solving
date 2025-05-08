import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        
        StringTokenizer st = new StringTokenizer(s);
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        String[] str = s.split(" ");
        for (int i = 0; i < str.length; i++) {
            int n = Integer.parseInt(str[i]);
            if (n > max) max = n;
            if (n < min) min = n;
        }
        answer += min + " " + max;
        
        return answer;
    }
}