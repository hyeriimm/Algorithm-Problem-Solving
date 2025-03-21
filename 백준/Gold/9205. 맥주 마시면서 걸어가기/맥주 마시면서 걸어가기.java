import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	private static int N;
	private static Point penta;
	private static Point[] conv;
	private static int[][] adjMatrix;
	private static boolean[] visited;
	private static StringBuilder sb;
	
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
		StringTokenizer st = null;
		sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			
			/* 0. Initialize */
			N = Integer.parseInt(br.readLine());
			conv = new Point[N + 1];
			adjMatrix = new int[N + 1][N + 1];
			visited = new boolean[N + 1];
			
			/* 1-1. Get position of home */
			st = new StringTokenizer(br.readLine());
			conv[0] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			
			/* 1-2. Get position of convenient store & Make adjacency matrix */
			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				for (int j = 0; j < i; j++) {
					if (Math.abs(conv[j].x - x) + Math.abs(conv[j].y - y) <= 1000) {
						adjMatrix[j][i] = 1;
						adjMatrix[i][j] = 1;
					}
				}
				conv[i] = new Point(x, y);
			}
			
			/* 1-3. Get position of pentaport */
			st = new StringTokenizer(br.readLine());
			penta = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			
			/* 2. BFS */
			bfs();
		}
		
		/* 3. Print result */
		System.out.println(sb);
	}
	
	private static void bfs() {
		
		Queue<Integer> queue = new ArrayDeque<>();
		
		queue.offer(0);
		visited[0] = true;
		
		while (!queue.isEmpty()) {
			
			int v = queue.poll();
			
			if (Math.abs(conv[v].x - penta.x) + Math.abs(conv[v].y - penta.y) <= 1000) {
				sb.append("happy\n");
				return;
			}
			
			for (int i = N; i > 0; i--) {
				if (!visited[i] && adjMatrix[i][v] == 1) {
					queue.offer(i);
					visited[i] =true;
				}
			}
		}
		
		sb.append("sad\n");
	}
}
