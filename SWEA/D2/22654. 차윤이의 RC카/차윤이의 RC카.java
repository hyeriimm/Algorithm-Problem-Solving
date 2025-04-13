import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	private static int N;
	private static char[][] map;
	private static Point start;
	private static Point end;
	private static int[] dx = { -1, 0, 1, 0 };
	private static int[] dy = { 0, 1, 0, -1 };
	
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

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc);
			
			/* 0. Initialize */
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			map = new char[N][N];

			/* 1. Get 2d map */
			for (int i = 0; i < N; i++) {
				map[i] = br.readLine().toCharArray();
				for (int j = 0; j < N; j++) {
					if (map[i][j] == 'X') {
						start = new Point(i, j);
					}
					else if (map[i][j] == 'Y') {
						end = new Point(i, j);
					}
				}
			}
			
			/* 2. Get command & Simulation */
			int Q = Integer.parseInt(br.readLine());
			
			for (int i = 0; i < Q; i++) {
				st = new StringTokenizer(br.readLine());
				int C = Integer.parseInt(st.nextToken());
				String com = st.nextToken(); 
				
				if (simulation(C, com)) sb.append(" 1");
				else sb.append(" 0");
			}

			/* 3. Print result */
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	/* 2. Simulation */
	private static boolean simulation(int C, String com) {

		int dir = 0;
		Point p = start;
		
		for (int i = 0; i < C; i++) {
			char c = com.charAt(i);

			if (c == 'A') {
				int newX = p.x + dx[dir];
				int newY = p.y + dy[dir];
				
				if (0 <= newX && newX < N && 0 <= newY && newY < N
						&& map[newX][newY] != 'T') {
					p = new Point(newX, newY);
				}
			}
			else if (c == 'L') {
				dir = (dir - 1 + 4) % 4;
			}
			else if (c == 'R') {
				dir = (dir + 1) % 4;
			}
		}
		
		if (p.x != end.x || p.y != end.y) return false;
		
		return true;
	}
}
