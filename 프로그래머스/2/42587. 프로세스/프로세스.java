import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        int prev = -1;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        Queue<Integer> queue = new ArrayDeque<>();
        
        for (int i = 0; i < priorities.length; i++) {
            pq.add(priorities[i]);
            queue.add(i);
        }
        
        while (!pq.isEmpty()) {
            int p = pq.poll();
            
            while (!queue.isEmpty()) {
                int idx = queue.poll();
                if (priorities[idx] == p) {
                    answer++;
                    if (idx == location) return answer;
                    else break;
                }
                else queue.add(idx);
            }
        }
        
        return answer;
    }
}