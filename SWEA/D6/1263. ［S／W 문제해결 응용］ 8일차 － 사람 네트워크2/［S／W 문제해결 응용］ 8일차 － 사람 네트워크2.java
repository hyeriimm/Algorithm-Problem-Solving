import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	private static int N;
	private static int[][] CC;
	
	/* Floyd-Warshall */
	private static void floyd() {
		
		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) { // update
					if (CC[i][k] + CC[k][j] < CC[i][j]) {
						CC[i][j] = CC[i][k] + CC[k][j];
					}
				}
			}
		}
	}
	
	private static int getMinCC() {
		int minCC = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			int sum = 0;
			for (int j = 0; j < N; j++) {
				sum += CC[i][j];
			}
			minCC = (minCC > sum) ? sum : minCC;
		}
		return minCC;
	}

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			
			/* 0. Initialize */
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			CC = new int[N][N];
			
			/* 1. Adjacency matrix */
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int weight = Integer.parseInt(st.nextToken());
					if (weight > 0)
						CC[i][j] = weight;
					else 
						CC[i][j] = 999999;
				}
				CC[i][i] = 0;
			}

			/* 2. Floyd-Warshall */
			floyd();
			
			/* 3. Print result */
			sb.append("#" + tc + " " + getMinCC() + "\n");
		}
		System.out.println(sb);
	}
}
