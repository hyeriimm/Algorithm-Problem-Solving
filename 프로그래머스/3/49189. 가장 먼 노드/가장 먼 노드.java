import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        
        /* 0. Initialize */
        List<List<Integer>> graph = new ArrayList<>();
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        int size = 0;
        
        for (int i = 0; i <= n; i++) 
            graph.add(new ArrayList<>());
        
        /* 1. Make adjacency list */
        for (int[] e : edge) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }

        queue.offer(1);
        visited[1] = true;

        while (!queue.isEmpty()) {
            size = queue.size();
            
            for (int s = 0; s < size; s++) {
                int curr = queue.poll();

                for (int next : graph.get(curr)) {
                    if (!visited[next]) {
                        visited[next] = true;
                        queue.offer(next);
                    }
                }
            }
        }

        return size;
    }
}
