import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> stack = new Stack<>();
        
        for (int sec = 0; sec < prices.length; sec++) {
            int currPrice = prices[sec];
            
            while(!stack.isEmpty()) {
                int p = stack.pop();
                if (currPrice < prices[p]) {
                    answer[p] = sec - p;
                }
                else {
                    stack.push(p);
                    break;
                }
            }
            stack.push(sec);
        }
        
        while (!stack.isEmpty()) {
            int p = stack.pop();
            answer[p] = prices.length - p - 1;
        }
        
        return answer;
    }
}