import java.util.*;

class Solution {
    public String solution(String number, int k) {
        
        StringBuilder answer = new StringBuilder();
        int len = number.length();
        int keep = len - k;

        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < len; i++) {
            char c = number.charAt(i);

            while (!stack.isEmpty() && k > 0 && stack.peekLast() < c) {
                stack.pollLast();
                k--;
            }

            stack.addLast(c);
        }

        // 남은 숫자 중 앞에서 keep개만 가져오기
        for (int i = 0; i < keep; i++) {
            answer.append(stack.pollFirst());
        }

        return answer.toString();
    }
}