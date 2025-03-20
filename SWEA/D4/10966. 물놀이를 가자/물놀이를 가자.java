import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	private static int N;
	private static int M;
	private static char[][] map;
	private static int[][] distance;
	private static int[] dx = { 0, 1, 0, -1 };
	private static int[] dy = { 1, 0, -1, 0};
	private static Queue<Point> queue;

	private static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + "]";
		}
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			/* 0. Initialize */
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new char[N][M];
			distance = new int[N][M];
			queue = new ArrayDeque<>();

			/* 1. Get map & find water */
			for (int i = 0; i < N; i++) {
				map[i] = br.readLine().toCharArray();
				for (int j = 0; j < M; j++) {
					if (map[i][j] == 'W')
						queue.offer(new Point(i, j));
				}
			}

			/* 2. BFS at all water */
			bfs();

			/* 3. Print result */
			sb.append("#" + tc + " " + totalDistance() + "\n");
		}
		System.out.println(sb);
	}

	/* BFS : return distance to water*/
	private static void bfs() {

		while (!queue.isEmpty()) {

			Point p = queue.poll();

			for (int i = 0; i < 4; i++) {
				int newX = p.x + dx[i];
				int newY = p.y + dy[i];

				if (0 <= newX && newX < N && 0<= newY && newY < M
						&& distance[newX][newY] == 0 && map[newX][newY] == 'L') {

					queue.offer(new Point(newX, newY));
					distance[newX][newY] = distance[p.x][p.y] + 1;
				}
			}
		}
	}
	
	private static int totalDistance() {
		int sum = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sum += distance[i][j];
			}
		}
		return sum;
	}
}
