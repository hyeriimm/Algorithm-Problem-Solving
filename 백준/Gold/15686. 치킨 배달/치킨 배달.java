import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static int N;
	private static int M;
	private static int[][] map;
	private static Point[] chicken;
	private static int cNum;
	private static Point[] retain;
	private static int hNum;
	private static Point[] home;
	private static int minTotalDistance;

	private static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	/* Get chicken distance of street */
	private static void getDistance() {
		int totalDistance = 0;
		
		for (int i = 0; i < hNum; i++) {
			int minDistance = Integer.MAX_VALUE;
			for (int j = 0; j < M; j++) {
				int distance = Math.abs(home[i].x - retain[j].x) + Math.abs(home[i].y - retain[j].y);
				if (minDistance > distance)
					minDistance = distance;
			}
			totalDistance += minDistance;
		}
		
		if (minTotalDistance > totalDistance)
			minTotalDistance = totalDistance;
	}

	/* Combination : select chicken house */
	private static void combination(int cnt, int start) {

		if (cnt == M) {
			getDistance();
			return;
		}

		for(int i = start; i < cNum; i++) {
			retain[cnt] = chicken[i];
			combination(cnt + 1, i + 1);
		}
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		/* 1. Get values */
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		chicken = new Point[13];
		retain = new Point[M];
		home = new Point[2 * N];
		minTotalDistance = Integer.MAX_VALUE;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					chicken[cNum++] = new Point(i, j);
				} else if (map[i][j] == 1) {
					home[hNum++] = new Point(i, j);
				}
			}
		}
		
		/* 2. Combination */
		combination(0, 0);

		/* 3. Print result */
		System.out.println(minTotalDistance);
	}
}
