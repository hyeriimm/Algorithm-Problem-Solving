import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	private static int N, M, L;
	private static int[][] map;
	private static boolean[][] visited;
	private static Point start;
	private static int[] dx = { -1, 0, 1, 0 };
	private static int[] dy = { 0, 1, 0, -1 };
	static int[][] haveDir = {
			{}, // 0
			{0,1,2,3}, // 1
			{0,2}, // 2
			{1,3}, // 3
			{0,1}, // 4
			{1,2}, // 5
			{2,3}, // 6
			{0,3}  // 7
	};
	private static int count;

	private static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
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
			M = Integer.parseInt(st.nextToken());
			start = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			L = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			visited = new boolean[N][M];
			count = 1;

			/* 1. Get 2d map */
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			/* 2. BFS */
			bfs();

			/* 3. Print result */
			sb.append("#").append(tc).append(" ").append(count).append("\n");
		}
		System.out.println(sb);
	}
	
	private static void bfs() {
		
		Queue<Point> queue = new ArrayDeque<>();
		queue.add(start);
		
		visited[start.x][start.y] = true;
		int time = 1;
		
		while (!queue.isEmpty()) {
			if (time++ == L) return;
			int size = queue.size();
			
			for (int s = 0; s < size; s++) {
				Point p = queue.poll();
				int curTunnel = map[p.x][p.y];

				for (int i = 0; i < haveDir[curTunnel].length; i++) {
					
					int dir = haveDir[curTunnel][i];
					int nx = p.x + dx[dir];
					int ny = p.y + dy[dir];
					
					if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
					if (map[nx][ny] == 0) continue;

					if (!canGo(nx, ny, (dir + 2) % 4)) continue;
					if (visited[nx][ny]) continue;

					visited[nx][ny] = true;
					queue.add(new Point(nx,ny));
					count++;
				}
			}
		}
	}
	
	private static boolean canGo(int x, int y, int direct) {
		int curDir = map[x][y];
		for (int d : haveDir[curDir]) {
			if (d == direct) 
				return true;
		}
		return false;
	}
}
