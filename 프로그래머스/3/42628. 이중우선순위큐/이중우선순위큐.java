import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {0, 0};

        PriorityQueue<Integer> maxPQ = new PriorityQueue<>((o1, o2) -> o2 - o1);
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();
        
        for (int i = 0; i < operations.length; i++) {
            String[] op = operations[i].split(" ");
            int num = Integer.parseInt(op[1]);
            
            if (op[0].equals("I")) {
                maxPQ.offer(num);
                minPQ.offer(num);
            }
            else { // equals "D"
                if (num == 1) {
                    if (!maxPQ.isEmpty()) minPQ.remove(maxPQ.poll());
                }
                else { // num == -1
                    if (!minPQ.isEmpty()) maxPQ.remove(minPQ.poll());
                }
            }
        }
        
        if (!maxPQ.isEmpty()) {
            answer[0] = maxPQ.poll();
            answer[1] = minPQ.poll();
        }
        
        return answer;
    }
}