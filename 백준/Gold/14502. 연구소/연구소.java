import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	private static int N;
	private static int M;
	private static int[][] map;
	private static ArrayList<Point> empty;
	private static ArrayList<Point> virus;
	private static Point[] newWall;
	private static boolean[][] visited;
	private static int[] dx = { 0, 1, 0, -1 };
	private static int[] dy = { 1, 0, -1, 0 };
	private static int maxSafe;

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

	/* 2-1. Combination : select 3 slot to make wall */
	private static void combination(int cnt, int start) {

		if (cnt == 3) {
			simulation();
			return;
		}

		for (int i = start; i < empty.size(); i++) {
			newWall[cnt] = empty.get(i);
			combination(cnt + 1, i + 1);
		}
	}

	/* 2-2. Simulation : make wall & count safe area */
	private static void simulation() {

		int safe = 0;
		visited = new boolean[N][M];

		// make wall
		for (int i = 0; i < 3; i++) {
			Point p = newWall[i];
			map[p.x][p.y] = 1;
		}

		// BFS
		for (Point v : virus) {
			bfs(v);
		}

		// count safe area
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!visited[i][j] && map[i][j] == 0) {
					safe++;
				}
			}
		}

		// update max safe area
		if (maxSafe < safe) maxSafe = safe;

		// reset
		for (int i = 0; i < 3; i++) {
			Point p = newWall[i];
			map[p.x][p.y] = 0;
		}
	}

	/* 2-3. BFS : Find safe area */
	private static void bfs(Point start) {

		Queue<Point> queue = new ArrayDeque<>();

		queue.offer(start);
		visited[start.x][start.y] = true;

		while (!queue.isEmpty()) {

			Point p = queue.poll();

			for (int i = 0; i < 4; i++) {
				int newX = p.x + dx[i];
				int newY = p.y + dy[i];
				if (0 <= newX && newX < N && 0 <= newY && newY < M
						&& !visited[newX][newY] && map[newX][newY] != 1) {
					queue.offer(new Point(newX, newY));
					visited[newX][newY] = true;
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		/* 0. Initialize */
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		empty = new ArrayList<>();
		virus = new ArrayList<>();
		newWall = new Point[3];
		maxSafe = 0;

		/* 1. Get 2d map */
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 0)
					empty.add(new Point(i, j));
				else if (map[i][j] == 2)
					virus.add(new Point(i, j));
			}
		}

		/* 2. Combination : select 3 slot to make wall */
		combination(0, 0);

		/* 3. Print result */
		sb.append(maxSafe);
		System.out.println(sb);
	}


}
