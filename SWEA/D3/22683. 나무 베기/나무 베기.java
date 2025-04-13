import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	private static int N;
	private static int K;
	private static char[][] map;
	private static boolean[][][][] visited;
	private static State start;
	private static State end;
	private static int[] dx = { -1, 0, 1, 0 };
	private static int[] dy = { 0, 1, 0, -1 };

	private static class State {
		int x, y, dir, cut, moves;

		public State(int x, int y, int dir, int cut, int moves) {
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.cut = cut;
			this.moves = moves;
		}
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			/* 0. Initialize */
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken()); 
			map = new char[N][N];
			visited = new boolean[N][N][4][K + 1];

			/* 1. Get 2d map */
			for (int i = 0; i < N; i++) {
				map[i] = br.readLine().toCharArray();
				for (int j = 0; j < N; j++) {
					if (map[i][j] == 'X') {
						start = new State(i, j, 0, 0, 0);
					}
					else if (map[i][j] == 'Y') {
						end = new State(i, j, 0, 0, 0);
					}
				}
			}

			/* 2. BFS */
			int result = bfs();

			/* 3. Print result */
			sb.append("#").append(tc).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}

	private static int bfs() {

		Queue<State> queue = new ArrayDeque<>();
		queue.offer(start);
		visited[start.x][start.y][0][0] = true;

		while (!queue.isEmpty()) {
			State cur = queue.poll();

			if (cur.x == end.x && cur.y == end.y) {
				return cur.moves;
			}

			// A
			int nx = cur.x + dx[cur.dir];
			int ny = cur.y + dy[cur.dir];

			if (isIn(nx, ny)) {

				if (map[nx][ny] == 'T') {
					if (cur.cut < K && !visited[nx][ny][cur.dir][cur.cut + 1]) {
						visited[nx][ny][cur.dir][cur.cut + 1] = true;
						queue.offer(new State(nx, ny, cur.dir, cur.cut + 1, cur.moves + 1));
					}
				}
				else { // G Y
					if (!visited[nx][ny][cur.dir][cur.cut]) {
						visited[nx][ny][cur.dir][cur.cut] = true;
						queue.offer(new State(nx, ny, cur.dir, cur.cut, cur.moves + 1));
					}
				}
			}

			// L
			int leftDir = (cur.dir + 3) % 4;
			if (!visited[cur.x][cur.y][leftDir][cur.cut]) {
				visited[cur.x][cur.y][leftDir][cur.cut] = true;
				queue.offer(new State(cur.x, cur.y, leftDir, cur.cut, cur.moves + 1));
			}

			// R
			int rightDir = (cur.dir + 1) % 4;
			if (!visited[cur.x][cur.y][rightDir][cur.cut]) {
				visited[cur.x][cur.y][rightDir][cur.cut] = true;
				queue.offer(new State(cur.x, cur.y, rightDir, cur.cut, cur.moves + 1));
			}
		}

		return -1;
	}

	static boolean isIn(int x, int y) {
		return 0 <= x && x < N && 0 <=y && y < N;
	}
}
