import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {

        int total = brown + yellow;
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 3; i <= Math.sqrt(total); i++) {
            if (total % i == 0)
                stack.push(i);
        }
        
        while (!stack.isEmpty()) {
            int h = stack.pop();
            int w = total / h;
            
            if ((h - 2) * (w - 2) == yellow) {
                return new int[] { w, h };
            }
        }
        
        return null;
    }
}