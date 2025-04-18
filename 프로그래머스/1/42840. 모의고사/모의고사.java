import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        
        int[] answer;
        int[] count = new int[3];
        int[] p2 = { 1, 3, 4, 5 };
        int[] p3 = { 3, 1, 2, 4, 5 };
        List<Integer> list = new ArrayList<>();
        
        int maxSolve = 0;
        
        for (int i = 0; i < answers.length; i++) {
            
            // person 1
            if (answers[i] == i % 5 + 1) count[0]++;
            
            // person 2
            if (i % 2 == 0) {
                if (answers[i] == 2) count[1]++;
            }
            else {
                if (answers[i] == p2[i / 2 % 4]) count[1]++;
            }
            
            // person 3
            if (answers[i] == p3[i / 2 % 5]) count[2]++;
        }
        
        for (int i = 0; i < 3; i++) {
            if (maxSolve < count[i]) {
                maxSolve = count[i];
                list.clear();
                list.add(i + 1);
            }
            else if (maxSolve == count[i])
                list.add(i + 1);
        }
        
        answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}