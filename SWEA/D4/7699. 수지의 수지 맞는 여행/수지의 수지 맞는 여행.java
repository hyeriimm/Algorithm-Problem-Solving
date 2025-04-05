import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {

	private static int R;
	private static int C;
	private static char[][] map;
	private static boolean[] visited;
	private static int[] dx = { 0, 1, 0, -1 };
	private static int[] dy = { 1, 0, -1, 0 };
	private static int maxCount;

	private static class Point {
		int x;
		int y;
		int count;

		public Point(int x, int y, int count) {
			super();
			this.x = x;
			this.y = y;
			this.count = count;
		}
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			/* 0. Initialize */
			StringTokenizer st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			map = new char[R][C];
			visited = new boolean[26];
			maxCount = 0;

			/* 1. Get map */
			for (int i = 0; i < R; i++) {
				String input = br.readLine();
				for (int j = 0; j < C; j++) {
					map[i][j] = input.charAt(j);
				}
			}

			/* 2. DFS */
			visited[map[0][0] - 'A'] = true;
			dfs(new Point(0, 0, 1));

			/* 3. Print result */
			sb.append("#").append(tc).append(" ").append(maxCount).append("\n");
		}
		System.out.println(sb);
	}

	private static void dfs(Point p) {

		if (maxCount == 26) return;

		if (maxCount < p.count)
			maxCount = p.count;

		for (int i = 0; i < 4; i++) {
			int newX = p.x + dx[i];
			int newY = p.y + dy[i];

			if (0 <= newX && newX < R && 0 <= newY && newY < C
					&& !visited[map[newX][newY] - 'A']) {

				visited[map[newX][newY] - 'A'] = true;
				dfs(new Point(newX, newY, p.count + 1));
				visited[map[newX][newY] - 'A'] = false;
			}
		}
	}
}
