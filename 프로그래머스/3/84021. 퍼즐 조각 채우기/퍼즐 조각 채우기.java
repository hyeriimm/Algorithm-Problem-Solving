import java.util.*;

class Solution {
    
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};
    int n;

    public int solution(int[][] game_board, int[][] table) {
        
        // 1. 빈 공간과 퍼즐 조각을 각각 추출
        n = game_board.length;
        List<List<int[]>> holes = extractShapes(game_board, 0);
        List<List<int[]>> blocks = extractShapes(table, 1);
        boolean[] used = new boolean[blocks.size()]; // 블록 사용 여부 체크
        int answer = 0;

        // 2. 빈칸마다 퍼즐 조각을 맞춰보기
        for (List<int[]> hole : holes) {
            for (int i = 0; i < blocks.size(); i++) {
                if (used[i]) continue;
                List<int[]> block = blocks.get(i);

                // 블록을 4번 회전하면서 맞는 모양이 있는지 확인
                for (int r = 0; r < 4; r++) {
                    block = rotate(block);
                    if (isSameShape(hole, block)) {
                        used[i] = true; // 사용한 퍼즐은 체크
                        answer += hole.size(); // 채운 칸 수 더하기
                        break;
                    }
                }
                // 이미 매치된 경우 다음 hole로 넘어감
                if (used[i]) break; 
            }
        }

        return answer;
    }

    /* 주어진 값(target: 0 or 1)에 해당하는 모양을 리스트로 추출 */
    List<List<int[]>> extractShapes(int[][] board, int target) {
        List<List<int[]>> shapes = new ArrayList<>();
        boolean[][] visited = new boolean[n][n];

        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                if (!visited[x][y] && board[x][y] == target) {
                    List<int[]> shape = new ArrayList<>();
                    dfs(x, y, board, visited, target, shape);
                    shapes.add(normalize(shape));
                }
            }
        }
        return shapes;
    }

    /* DFS : 연결된 블록 혹은 빈칸을 찾아서 shape에 저장 */
    void dfs(int x, int y, int[][] board, boolean[][] visited, int target, List<int[]> shape) {
        visited[x][y] = true;
        shape.add(new int[]{x, y});
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (0 <= nx && nx < n && 0 <= ny && ny < n) {
                if (!visited[nx][ny] && board[nx][ny] == target) {
                    dfs(nx, ny, board, visited, target, shape);
                }
            }
        }
    }

    /* 좌표들을 (0,0) 기준으로 정규화 */
    List<int[]> normalize(List<int[]> shape) {
        int minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE;
        for (int[] p : shape) {
            minX = Math.min(minX, p[0]);
            minY = Math.min(minY, p[1]);
        }
        List<int[]> normalized = new ArrayList<>();
        for (int[] p : shape) {
            normalized.add(new int[]{p[0] - minX, p[1] - minY}); // 기준점 이동
        }
        // 비교를 위해 정렬
        normalized.sort((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        return normalized;
    }

    /* 퍼즐 조각을 90도 회전 */
    List<int[]> rotate(List<int[]> shape) {
        List<int[]> rotated = new ArrayList<>();
        for (int[] p : shape) {
            rotated.add(new int[]{p[1], -p[0]});
        }
        return normalize(rotated);
    }

    /* 두 도형이 동일한 모양인지 비교 */
    boolean isSameShape(List<int[]> a, List<int[]> b) {
        if (a.size() != b.size()) return false;
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i)[0] != b.get(i)[0] || a.get(i)[1] != b.get(i)[1]) return false;
        }
        return true;
    }
}
