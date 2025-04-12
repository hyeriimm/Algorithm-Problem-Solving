import java.util.*;

class Solution {
    
    int N;
    int[][] adjMatrix;
    boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        
        N = n;
        adjMatrix = computers;
        visited = new boolean[n];
        int answer = 0;
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                bfs(i);
                answer++;
            }
        }
        
        return answer;
    }
    
    void bfs(int start) {
        
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        
        while (!queue.isEmpty()) {
            int v = queue.poll();
            
            for (int i = 0; i < N; i++) {
                if (!visited[i] && adjMatrix[v][i]== 1 && i != v) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
        
        return;
    }
}