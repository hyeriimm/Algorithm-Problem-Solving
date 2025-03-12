import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	private static int N;
	private static int[] X;
	private static int[] M;
	
	private static double getBalance(int n) {
		
		double low = X[n];
		double high = X[n + 1];
		double point = 0;

		while (high - low >= 1e-12) {

			point = (low + high) / 2;
			
			
			double f1 = 0.0;
			double f2 = 0.0;
			
			for (int i = 0; i <= n; i++) {
				f1 += M[i] / ((point - X[i]) * (point - X[i]));
			}
			for (int i = n + 1; i < N; i++) {
				f2 += M[i] / ((X[i] - point) * (X[i] - point));
			}
			
			if (f1 < f2) {
				high = point;
			}
			else if (f1 > f2) {
				low = point;
			} else {
				return point;
			}
		}
		
		return point;
	}

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#" + tc);
			
			N = Integer.parseInt(br.readLine());
			X = new int[N];
			M = new int[N];
			
			StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
			for (int i = 0; i < N; i++) {
				X[i] = Integer.parseInt(st.nextToken());
			}
			for (int i = 0; i < N; i++) {
				M[i] = Integer.parseInt(st.nextToken());
			}
			
			for (int i = 0; i < N - 1; i++) {
				sb.append(String.format(" %.10f", getBalance(i)));
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
