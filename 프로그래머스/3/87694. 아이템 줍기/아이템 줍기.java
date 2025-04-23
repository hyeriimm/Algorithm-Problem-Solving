import java.util.*;

class Solution {
    
    class Point {
        int x;
        int y;
        int path;
        
        Point(int x, int y, int path) {
            this.x = x;
            this.y = y;
            this.path = path;
        }
    }
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        
        /* 0. Initialize */
        int[][] map = new int[101][101];
        int[] dx = { 1, 0, -1, 0 };
        int[] dy = { 0, 1, 0, -1 };
        
        /* 1. Make map (1 : border, 2 : inside) */
        for (int i = 0; i < rectangle.length; i++) {
            int x1 = rectangle[i][0] * 2;
            int y1 = rectangle[i][1] * 2;
            int x2 = rectangle[i][2] * 2;
            int y2 = rectangle[i][3] * 2;
            
            for (int x = x1; x <= x2; x++) {
                if (map[x][y1] == 0) map[x][y1] = 1;
                if (map[x][y2] == 0) map[x][y2] = 1;
            }
            for (int y = y1; y <= y2; y++) {
                if (map[x1][y] == 0) map[x1][y] = 1;
                if (map[x2][y] == 0) map[x2][y] = 1;
            }
            
            for (int x = x1 + 1; x < x2; x++) {
                for (int y = y1 + 1; y < y2; y++) {
                    map[x][y] = 2;
                }
            }
        }
        
        /* 2. BFS */       
        Queue<Point> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[101][101];
        
        queue.add(new Point(characterX * 2, characterY * 2, 0));
        visited[characterX * 2][characterY * 2] = true;
        
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            
            if (itemX * 2 == p.x && itemY * 2 == p.y) {
                return p.path / 2;
            }
            
            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                
                if (0 > nx || nx > 100 || 0 > ny || ny > 100) continue;
                if (visited[nx][ny] || map[nx][ny] != 1) continue;
                
                queue.add(new Point(nx, ny, p.path + 1));
                visited[nx][ny] = true;
            }
        }
        
        return 0;
    }
}