import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	private static int W;
	private static int H;
	private static int[][] map;
	private static boolean[][][] visited;
	private static int[] dx = { 0, 1, 0, -1 };
	private static int[] dy = { 1, 0, -1, 0 };
	private static int[] hx = { -1, -2, -2, -1, 1, 2, 2, 1 };
	private static int[] hy = { -2, -1, 1, 2, 2, 1, -1, -2 };

	private static class Point {
		int x;
		int y;
		int horse;
		int depth;

		public Point(int x, int y, int horse, int depth) {
			this.x = x;
			this.y = y;
			this.horse = horse;
			this.depth = depth;
		}

		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + ", horse=" + horse + ", depth=" + depth + "]";
		}

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int K = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new int[H][W];
		visited = new boolean[K+1][H][W];

		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine().trim(), " ");
			for (int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		bfs(new Point(0, 0, K, 0));

	}

	private static void bfs(Point start) {

		Queue<Point> queue = new ArrayDeque<>();
		StringBuilder sb = new StringBuilder();

		queue.offer(start);
		visited[0][start.x][start.y] = true;

		while (!queue.isEmpty()) {

			Point p = queue.poll();

			if (p.x == H - 1 && p.y == W - 1) {
				sb.append(p.depth);
				System.out.println(sb);
				return;
			}

			if (p.horse > 0) {
				for (int i = 0; i < 8; i++) {
					int newX = p.x + hx[i];
					int newY = p.y + hy[i];
					
					if (0 <= newX && newX < H && 0 <= newY && newY < W
							&& !visited[p.horse - 1][newX][newY] && map[newX][newY] == 0) {
						queue.offer(new Point(newX, newY, p.horse - 1, p.depth + 1));
						visited[p.horse - 1][newX][newY] = true;
					}
				}
			}
			
			for (int i = 0; i < 4; i++) {
				int newX = p.x + dx[i];
				int newY = p.y + dy[i];
				
				if (0 <= newX && newX < H && 0 <= newY && newY < W
						&& !visited[p.horse][newX][newY] && map[newX][newY] == 0) {
					queue.offer(new Point(newX, newY, p.horse, p.depth + 1));
					visited[p.horse][newX][newY] = true;
				}
			}
		}
		sb.append("-1");
		System.out.println(sb);
	}
}
