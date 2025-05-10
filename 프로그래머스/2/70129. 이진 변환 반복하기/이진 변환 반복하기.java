import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        List<Integer> list = new ArrayList<>();
        
        while (!s.equals("1")) {
            
            int cnt = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '1') cnt++;
            }
            answer[0]++;
            answer[1] += s.length() - cnt;
            
            s = Integer.toBinaryString(cnt);
        }
        
        return answer;
    }
}