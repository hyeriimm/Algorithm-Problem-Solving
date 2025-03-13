import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

	private static int N;
	private static char[][] art;
	private static boolean[][] visited;
	private static int[] dx = { 0, 1, 0, -1 };
	private static int[] dy = { 1, 0, -1, 0 };
	private static int normal;
	private static int colorBlind;
	
	private static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		/* 1. Initialize */
		N = Integer.parseInt(br.readLine());
		art = new char[N][N];

		for (int i = 0; i < N; i++) {
			art[i] = br.readLine().toCharArray();
		}

		/* 2-2. Count number of area - normal */
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					normal++;
					bfs(new Point(i, j));
				}
				// change green to red (for 2-2)
				if (art[i][j] == 'G') art[i][j] = 'R';
			}
		}
		
		/* 2-2. Count number of area - color blind */
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					colorBlind++;
					bfs(new Point(i, j));
				}
			}
		}

		/* 3. Print result */
		sb.append(normal + " " + colorBlind);
		System.out.println(sb);
	}

	private static void bfs(Point start) {
		
		Queue<Point> queue = new ArrayDeque<>();
		
		queue.offer(start);
		visited[start.x][start.y] = true;
		
		while (!queue.isEmpty()) {
			
			Point p = queue.poll();
			
			for (int i = 0; i < 4; i++) {
				int newX = p.x + dx[i];
				int newY = p.y + dy[i];
				
				if (0 <= newX && newX < N && 0 <= newY && newY < N
						&& !visited[newX][newY] && art[p.x][p.y] == art[newX][newY]) {
					queue.offer(new Point(newX, newY));
					visited[newX][newY] = true;
				}
			}
		}
	}
}
