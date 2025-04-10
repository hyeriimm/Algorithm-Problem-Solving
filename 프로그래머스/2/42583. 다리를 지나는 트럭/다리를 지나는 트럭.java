import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        int sum = 0;
        int idx = 0;
        
        for (int i = 0; i < bridge_length; i++)
            queue.add(0);
        
        while (!queue.isEmpty()) {
            int pass = queue.poll();
            sum -= pass;
            
            if (idx == truck_weights.length);
            else if (weight >= sum + truck_weights[idx]) {
                queue.add(truck_weights[idx]);
                sum += truck_weights[idx];
                idx++;
            }
            else queue.add(0);
            
            answer++;
        }
        
        return answer;
    }
}