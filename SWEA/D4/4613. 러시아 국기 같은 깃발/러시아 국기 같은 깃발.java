import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	private static int N;
	private static int M;
	private static int[] W;
	private static int[] B;
	private static int[] R;
	private static int minPaint;
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			/* 0. Initialize */
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			W = new int[N];
			B = new int[N];
			R = new int[N];
			minPaint = M * N;
			
			/* 1. Count color */
			for (int i = 0; i < N; i++) {
				String line = br.readLine();
				
				for (int j = 0; j < M; j++) {
					char c = line.charAt(j);
					if (c == 'W') W[i]++;
					else if (c == 'B') B[i]++;
					else if (c == 'R') R[i]++;
				}
			}
			
			/* 2. Use Combination */
			
			int white = 0;
			
			for (int k = 1; k < N - 1; k++) {

				white += M - W[k - 1];
				
				for (int j = k + 1; j < N; j++) {
					
					int paint = white; // White
					
					for (int i = k; i < j; i++) { // Blue
						paint += M - B[i];
					}
					for (int i = j; i < N; i++) { // Red
						paint += M - R[i];
					}
					
					if (minPaint > paint)
						minPaint = paint;
				}
			}

			/* 3. Print result */
			System.out.println("#" + tc + " " + minPaint);
		}
	}
}
