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
			int[] scores = new int[N];
			int sum = 0;
			
			/* 1. Get scores */
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				scores[i] = Integer.parseInt(st.nextToken());
			}
			
			/* 2. Sort & Get max sum */
			Arrays.sort(scores);
			for (int i = 0; i < K; i++) {
				sum += scores[N - 1 - i];
			}
			
			/* 3. Print result */
			sb.append("#" + tc + " " + sum + "\n");
		}
		System.out.println(sb);
	}
}
