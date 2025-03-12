import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution {

	private static int N;
	private static Point company;
	private static Point home;
	private static Point[] client;
	private static boolean[] isSelected;
	private static int minDistance;

	private static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	private static void permutation(int cnt, int sum, Point prev) {

		if (cnt == N) {

			int distance = sum + Math.abs(prev.x - home.x) + Math.abs(prev.y - home.y);
		
			if (minDistance > distance)
				minDistance = distance;

			return ;
		}
		
		if (minDistance < sum) return;

		for (int i = 0; i < N; i++) {

			if (isSelected[i]) {
				continue;
			}

			isSelected[i] = true;
			if (cnt == 0) {
				permutation(cnt+1, Math.abs(company.x - client[i].x) + Math.abs(company.y - client[i].y), client[i]);
			} else {
				permutation(cnt+1, sum + Math.abs(prev.x - client[i].x) + Math.abs(prev.y - client[i].y), client[i]);
			}
			isSelected[i] = false;
		}
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			N = Integer.parseInt(br.readLine());

			/* 0. Initialize */
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			company = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			home= new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			client = new Point[N];
			isSelected = new boolean[N];
			minDistance = Integer.MAX_VALUE;

			/* 1. Get client position */
			for (int i = 0; i < N; i++) {
				client[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			
			Arrays.sort(client, new Comparator<Point>() {
				@Override
				public int compare(Point o1, Point o2) {
					int d1 = Math.abs(company.x - o1.x) + Math.abs(company.y - o1.y);
					int d2 = Math.abs(company.x - o2.x) + Math.abs(company.y - o2.y);
					return d1 - d2;
				}
			});

			/* 2. Calculate distance */
			permutation(0, 0, null);

			/* 3. Print result */
			sb.append("#" + tc + " " + minDistance + "\n");
		}
		System.out.println(sb);
	}
}
