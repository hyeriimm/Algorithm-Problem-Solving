import java.util.*;

class Solution {
    static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[] dy = {1, 1, 0, -1, -1, -1, 0, 1};

    public int solution(int[] arrows) {
        Set<String> visitedEdges = new HashSet<>();
        Set<String> visitedNodes = new HashSet<>();
        
        int x = 0, y = 0;
        visitedNodes.add("0,0");
        
        int rooms = 0;
        
        for (int d : arrows) {
            // 대각선 교차 방지 위해 2번 반복 (2배)
            for (int k = 0; k < 2; k++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                String edge1 = x + "," + y + "-" + nx + "," + ny;
                String edge2 = nx + "," + ny + "-" + x + "," + y;
                String node = nx + "," + ny;

                if (visitedEdges.contains(edge1) == false) {
                    visitedEdges.add(edge1);
                    visitedEdges.add(edge2);

                    if (visitedNodes.contains(node)) {
                        rooms++; // 처음 가는 간선, 이미 방문한 점 → 방 생김
                    }
                }

                visitedNodes.add(node);

                x = nx;
                y = ny;
            }
        }
        
        return rooms;
    }
}
