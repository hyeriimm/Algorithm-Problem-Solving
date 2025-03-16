import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			/* 0. Initialize */
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int winner = 0;
			int maxSolve = 0;

			
			for (int i = 0; i < N; i++) {
				
				/* 1. Get count of one person */
				int solve = 0;
			
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < M; j++) {
					if (Integer.parseInt(st.nextToken()) == 1) {
						solve++;
					}
				}
				
				/* 2. Update result */
				if (solve == maxSolve) {
					winner++;
				}
				else if (solve > maxSolve) {
					winner = 1;
					maxSolve = solve;
				}
			}
			
			/* 3. Print result */
			sb.append("#" + tc + " " + winner + " " + maxSolve + "\n");
		}
		System.out.println(sb);
	}
}
