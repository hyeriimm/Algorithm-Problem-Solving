import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#" + tc);

			/* 1. Initialize */
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			boolean[] submit = new boolean[N + 1];

			/* 2. Get submitted students */
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < K; i++) {
				int n = Integer.parseInt(st.nextToken());
				submit[n] = true;
			}

			/* 3. Print result */
			for (int i = 1; i <= N; i++) {
				if (!submit[i])
					sb.append(" " + i);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
