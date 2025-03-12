import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	private static int R;
	private static int C;
	private static char[][] map;
	private static int[] dx = { 1, 0, -1 };
	private static int[] trace;
	private static int count;

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

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		trace = new int[C];

		/* 1. Get map */
		for (int i = 0; i < R; i++) {
			String input = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = input.charAt(j);
			}
		}

		/* 2. DFS at every row */
		for (int i = 0; i < R; i++) {
			trace[0] = i;
			dfs(new Point(i, 0));
		}

		/* 3. Print result */
		System.out.println(count);
	}

	private static void dfs(Point start) {

		Stack<Point> stack = new Stack<>();
		stack.add(start);

		while (!stack.isEmpty()) {
			Point p = stack.pop();
			map[p.x][p.y] = '+';
			
			if (p.y == C - 1) {
				count++;
				return;
			}

			for (int i = 0; i < 3; i++) {
				int newX = p.x + dx[i];
				int newY = p.y + 1;

				if (0 <= newX && newX < R && 0 <= newY && newY < C
						&& map[newX][newY] == '.') {
					stack.push(new Point(newX, newY));
				}
			}
		}
	}
}
