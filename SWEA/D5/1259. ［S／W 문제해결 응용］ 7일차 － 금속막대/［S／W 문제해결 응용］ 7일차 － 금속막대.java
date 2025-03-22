import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	private static int N;
	private static Bar[] bars;
	private static int[] numbers;
	private static StringBuilder sb;

	private static class Bar {
		
		int left;
		int right;

		public Bar(int left, int right) {
			super();
			this.left = left;
			this.right = right;
		}
	}

	/* DFS */
	private static void dfs(int cnt) {

		if (cnt == N) {
			for (int i = 0; i < N; i++)
				sb.append(" " + bars[numbers[i]].left + " " + bars[numbers[i]].right);

			return;
		}
		
		for (int i = 0; i < N; i++) {
			if (bars[numbers[cnt - 1]].right == bars[i].left) {
				numbers[cnt] = i;
				dfs (cnt + 1);
			}
		}
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			/* 0. Initialize */
			sb.append("#" + tc);
			N = Integer.parseInt(br.readLine());
			bars = new Bar[N];
			numbers = new int[N];

			/* 1. Get bars */
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				bars[i] = new Bar(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}

			/* 2. DFS */
			for (int i = 0; i < N; i++) {
				numbers[0] = i;
				dfs(1);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
