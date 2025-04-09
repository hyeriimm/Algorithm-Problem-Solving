import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        Queue<Integer> queue = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < speeds.length; i++) {
            int day = (100 - progresses[i] - 1) / speeds[i] + 1;
            queue.add(day);
        }
        
        int day = queue.poll();
        int count = 1;
        
        while (!queue.isEmpty()) {
            int next = queue.poll();
            if (day < next) {
                list.add(count);
                count = 1;
                day = next;
            }
            else {
                count++;
            }
        }
        list.add(count);
        
        answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}