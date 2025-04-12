import java.util.*;

class Solution {
    
    int[] dx = { 0, 1, 0, -1 };
    int[] dy = { 1, 0, -1, 0 };
    
    class Point {
        int x;
        int y;
        int dist;
        
        public Point(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
    
    public int solution(int[][] maps) {
        int N = maps.length;
        int M = maps[0].length;
        boolean[][] visited = new boolean[N][M];
        
        Queue<Point> queue = new ArrayDeque<>();
        queue.add(new Point(0, 0, 1));
        
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            
            if (p.x == N - 1 && p.y == M - 1) {
                return p.dist;
            }
         
            for (int i = 0; i < 4; i++) {
                int newX = p.x + dx[i];
                int newY = p.y + dy[i];
                
                if (0 <= newX && newX < N && 0 <= newY && newY < M
                   && !visited[newX][newY] && maps[newX][newY] == 1) {
                    queue.add(new Point(newX, newY, p.dist + 1));
                    visited[newX][newY] = true;
                }
            }
        }
        
        return -1;
    }
}