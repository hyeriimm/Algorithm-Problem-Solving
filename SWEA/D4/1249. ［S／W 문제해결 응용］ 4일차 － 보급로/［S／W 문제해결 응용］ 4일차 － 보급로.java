import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {

	private static int N;
	private static char[][] map;
	private static int[][] distance;
	private static boolean[][] visited;
	private static int[] dx = { 0, 1, 0, -1 };
	private static int[] dy = { 1, 0, -1, 0 };
	
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
			
			/* 0. Initialize */
			N = Integer.parseInt(br.readLine());
			map = new char[N][N];
			distance = new int[N][N];
			visited = new boolean[N][N];
			
			/* 1. Get map */
			for (int i = 0; i < N; i++) {
				map[i] = br.readLine().toCharArray();
				Arrays.fill(distance[i], 999999);
			}
			distance[0][0] = 0;
			
			/* 2. Dijkstra : find min path */
			dijkstra(new Point(0, 0));
			
			/* 3. Print result */
			sb.append("#" + tc + " " + distance[N-1][N-1] + "\n");
		}
		System.out.println(sb);
	}
	
	/* Dijkstra : find min path */
	private static void dijkstra(Point start) {
		
		PriorityQueue<Point> pq = new PriorityQueue<>(new Comparator<Point>() {
			@Override
			public int compare(Point o1, Point o2) {
				return distance[o1.x][o1.y] - distance[o2.x][o2.y];
			}
		});
		
		pq.offer(start);
		
		while (!pq.isEmpty()) {
			
			Point p = pq.poll();
			
			if (visited[p.x][p.y]) continue;
			visited[p.x][p.y] = true;
			
			if (p.x == N-1 && p.y == N-1) {
				break;
			}
			
			for (int i = 0; i < 4; i++) {
				int newX = p.x + dx[i];
				int newY = p.y + dy[i];
				
				if (0 <= newX && newX < N && 0 <= newY && newY < N && !visited[newX][newY] 
						&& distance[newX][newY] > distance[p.x][p.y] + map[newX][newY] - '0') {
					
					distance[newX][newY] = distance[p.x][p.y] + map[newX][newY] - '0';
					pq.offer(new Point(newX, newY));
				}
			}
		}
	}
}
