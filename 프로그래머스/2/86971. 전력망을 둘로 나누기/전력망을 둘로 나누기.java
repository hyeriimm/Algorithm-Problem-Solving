import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        
        for (int cut = 0; cut < wires.length; cut++) {
            
            /* BFS */
            Queue<Integer> queue = new ArrayDeque<>();
            boolean[] visited = new boolean[n + 1];
            int count = n;
            
            queue.add(wires[0][0]);
            visited[wires[0][0]] = true;

            while (!queue.isEmpty()) {
                int v = queue.poll();
                count -= 2;
                
                for (int i = 0; i < wires.length; i++) {
                    if (i == cut) continue;
                    
                    if (wires[i][0] == v) {
                        int w = wires[i][1];
                        if (visited[w]) continue;
                        visited[w] = true;
                        queue.add(w);
                    }
                    else if (wires[i][1] == v) {
                        int w = wires[i][0];
                        if (visited[w]) continue;
                        visited[w] = true;
                        queue.add(w);
                    }
                }
            }
            
            if (answer > Math.abs(count)) answer = Math.abs(count);
        }
        
        return answer;
    }
}