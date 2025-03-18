import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	private static int N;
	private static int M;
	
	/* Combination count */
	private static int bino(int n, int k) {
		
		int[][] D = new int[n + 1][n + 1];
		
		for (int i = 0; i <= n; i++) {
			int end = Math.min(i, k);
			for (int j = 0; j <= end; j++) {
				if (j == 0 || j == i) {
					D[i][j] = 1;
				}
				else {
					D[i][j] = D[i - 1][j - 1] + D[i - 1][j];
				}
			}
		}
		
		return D[n][k];
	}
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			/* Combination count */
			sb.append(bino(M, N) + "\n");
		}
		System.out.println(sb);
	}
}
