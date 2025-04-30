import java.util.*;

class Solution {
    public int solution(String s) {
        
        ArrayDeque<Character> dq = new ArrayDeque<>();
        
        for (int i = 0; i < s.length(); i++) {
            dq.add(s.charAt(i));
        }
        
        for (int i = 0; i < s.length(); i++) {
            
            Stack<Character> stack = new Stack<>();
            boolean isValid = true;
            int count = 0;
            
            for (char c : dq) {
                
                if (c == '(' || c == '[' || c == '{')
                    stack.push(c);
                else if (c == ')') {
                    if (!stack.isEmpty() && stack.pop() == '(');
                    else {
                        isValid = false;
                        break;
                    }
                }
                else if (c == ']') {
                    if (!stack.isEmpty() && stack.pop() == '[');
                    else {
                        isValid = false;
                        break;
                    }
                }
                else if (c == '}') {
                    if (!stack.isEmpty() && stack.pop() == '{');
                    else {
                        isValid = false;
                        break;
                    }
                }
                
                if (stack.isEmpty()) count++;
            }
            
            if (isValid) return count;
            
            dq.add(dq.poll());
        }
        
        return 0;
    }
}