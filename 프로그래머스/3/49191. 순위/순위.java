import java.util.*;

class Solution {
    public int solution(int n, int[][] results) {
        
        /* 0. Initialize */
        boolean[][] adjMatrix = new boolean[n + 1][n + 1];
        int answer = 0;
        
        /* 1. Make adjacency matrix */
        for (int[] e : results) {
            adjMatrix[e[0]][e[1]] = true;
        }

        /* 2. BFS */
        for (int i = 1; i <= n; i++) {
            boolean[] visited = new boolean[n + 1];
            Queue<Integer> queue = new ArrayDeque<>();
            
            queue.offer(i);
            visited[i] = true;
            
            while (!queue.isEmpty()) {
                int v = queue.poll();

                for (int w = 1; w <= n; w++) {
                    if (!visited[w] && adjMatrix[v][w]) {
                        visited[w] = true;
                        queue.offer(w);
                    }
                }
            }
            
            queue.offer(i);
            
            while (!queue.isEmpty()) {
                int v = queue.poll();

                for (int w = 1; w <= n; w++) {
                    if (!visited[w] && adjMatrix[w][v]) {
                        visited[w] = true;
                        queue.offer(w);
                    }
                }
            }
            
            int cnt = 0;
            for (int j = 1; j <= n; j++) {
                if (visited[j]) cnt++;
            }
            if (cnt == n) answer++;
        }    

        return answer;
    }
}