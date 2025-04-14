import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        Queue<String> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[words.length];
        
        queue.add(begin);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            for (int s = 0; s < size; s++) {
                String str = queue.poll();
                
                if (str.equals(target)) return answer;
                
                for (int i = 0; i < words.length; i++) {
                    if (visited[i]) continue;
                    int count = 0;
                    
                    for (int j = 0; j < str.length(); j++) {
                        if (words[i].charAt(j) != str.charAt(j)) count++;
                    }
                    
                    if (count == 1) {
                        visited[i] = true;
                        queue.add(words[i]);
                    }
                }
            }
            answer++;
        }
        
        return 0;
    }
}