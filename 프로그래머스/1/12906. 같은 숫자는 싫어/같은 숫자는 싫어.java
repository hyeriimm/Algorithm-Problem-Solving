import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer;
        List<Integer> list = new ArrayList<Integer>();
        int prev = -1;
        
        for (int n : arr) {
            if (n != prev) {
                list.add(n);
                prev = n;
            }
        }
        
        answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}