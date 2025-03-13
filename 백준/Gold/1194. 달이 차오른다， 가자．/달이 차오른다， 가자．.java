import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	private static int N;
	private static int M;
	private static char[][] maze;
	private static boolean[][][] visited;
	private static int[] dx = { 0, 1, 0, -1 };
	private static int[] dy = { 1, 0, -1, 0 };

	private static class Point {

		int x;
		int y;
		int depth;
		int key;

		public Point(int x, int y, int depth, int key) {
			super();
			this.x = x;
			this.y = y;
			this.depth = depth;
			this.key = key;
		}
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		/* 0. Initialize */
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		maze = new char[N][M];
		visited = new boolean[64][N][M];
		Point start = null;

		/* 1. Get maze & Find start point */
		for (int i = 0; i < N; i++) {
			maze[i] = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				if (maze[i][j] == '0') {
					start = new Point(i, j, 0, 0);
				}
			}
		}

		/* 2. BFS */
		sb.append(bfs(start));

		/* 3. Print result */
		System.out.println(sb);
	}

	private static int bfs(Point start) {

		Queue<Point> queue = new ArrayDeque<>();
		queue.offer(start);
		visited[0][start.x][start.y] = true;

		while (!queue.isEmpty()) {

			Point p = queue.poll();

			if (maze[p.x][p.y] == '1') {
				return p.depth;
			}

			for (int i = 0; i < 4; i++) {

				int newX = p.x + dx[i];
				int newY = p.y + dy[i];

				if (0 <= newX && newX < N && 0 <= newY && newY < M // check boundary
						&& !visited[p.key][newX][newY] && maze[newX][newY] != '#') { 
						// not visited with this key && not blocked

					if ('a' <= maze[newX][newY] && maze[newX][newY] <= 'f') { // found key
						
						int newKey = 1 << (maze[newX][newY] - 'a'); // get new key
						newKey = newKey | p.key; // add key
						
						if (!visited[newKey][newX][newY]) {
							visited[p.key][newX][newY] = true;
							visited[newKey][newX][newY] = true;
							queue.offer(new Point(newX, newY, p.depth + 1, newKey));
						}

					} else if ('A' <= maze[newX][newY] && maze[newX][newY] <= 'F') { // found door
						
						int door = 1 << (maze[newX][newY] - 'A'); // get door
						if ((p.key & door) > 0) { // check key matches the door
							visited[p.key][newX][newY] = true;
							queue.offer(new Point(newX, newY, p.depth + 1, p.key));
						}

					} else { // nothing ... just move
						visited[p.key][newX][newY] = true;
						queue.offer(new Point(newX, newY, p.depth + 1, p.key));
					}
				}
			}
		}

		return -1;
	}
}
