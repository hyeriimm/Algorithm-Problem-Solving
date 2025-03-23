import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	private static int[][] DP;
	
	/* Binomial : Combination Count */
	private static void bino(int N) {
		
		DP = new int[N + 1][N + 1];
		
		for (int i = 0; i <= N; i ++) {
			
			for (int j = 0; j <= i; j++) {
				if (j == 0 || j == i) {
					DP[i][j] = 1;
				}
				else {
					DP[i][j] = DP[i - 1][j - 1] + DP[i - 1][j];
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		int[] prime = { 2, 3, 5, 7, 11, 13, 17 };
		
		/* 1. Binomial : Combination Count */
		bino(18);
		
		for (int tc = 1; tc <= T; tc++) {
			
			/* 0. Initialize */
			StringTokenizer st = new StringTokenizer(br.readLine());
			double A = Double.parseDouble(st.nextToken()) / 100;
			double B = Double.parseDouble(st.nextToken()) / 100;
			double primeA = 0;
			double primeB = 0;
			double result = 0;
			
			/* 2. Calculate probability - prime number of completed product */
			for (int i : prime) {
				primeA += DP[18][i] * Math.pow(A, i) * Math.pow((1-A), (18-i));
				primeB += DP[18][i] * Math.pow(B, i) * Math.pow((1-B), (18-i));
			}

			/* 3. Print result */
			result = 1 - ((1 - primeA) * (1 - primeB));
			sb.append("#" + tc + " " + String.format("%.6f", result) + "\n");
		}
		System.out.println(sb);
	}
}
