import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			
			/* 0. Initialize */
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int[] lecture = new int[N];
			double result = 0;
			
			/* 1. Get lecture difficulties */
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				lecture[i] = Integer.parseInt(st.nextToken());
			}
			
			/* 2. Calculate maximum */
			Arrays.sort(lecture);
			for (int i = N - K; i < N; i++) {
				result = (result + lecture[i]) / 2;
			}
			
			/* 3. Print result */
			sb.append("#" + tc + " " + String.format("%.6f", result) + "\n");
		}
		System.out.println(sb);
	}
}
