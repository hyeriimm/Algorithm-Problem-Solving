import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	private static int N;
	private static int[][] P;
	private static boolean[] visited;
	private static double maxResult;

	private static void dfs(int cnt, double result) {

		if (cnt == N) {
			if (maxResult < result) maxResult = result;
			return;
		}
		
		if (maxResult >= result) return;

		for (int i = 0; i < N; i++) {

			if (!visited[i]) {
				double prob = P[cnt][i] / 100.0;
				visited[i] = true;
				dfs(cnt + 1, result * prob);
				visited[i] = false;
			}
		}
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			/* 0. Initialize */
			N = Integer.parseInt(br.readLine());
			P = new int[N][N];
			visited = new boolean[N];
			maxResult = 0.0;

			/* 1. Get numbers */
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					P[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			/* 2. Back Tracking */
			dfs(0, 100.0);

			/* 3. Print result */
			sb.append("#" + tc + " " + String.format("%.6f", maxResult) + "\n");
		}
		System.out.println(sb);
	}
}
