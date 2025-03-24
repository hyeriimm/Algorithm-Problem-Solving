import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	private static int N;
	private static int M;
	private static int[] A;
	private static int[] B;
	private static int[] count;
	private static int maxIdx;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			
			/* 0. Initialize */
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			A = new int[N];
			B = new int[M];
			count = new int[N];
			maxIdx = 0;
			
			/* 1. Get 1d array */
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				A[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				B[i] = Integer.parseInt(st.nextToken());
			}
			
			/* 2-1. Count the votes */
			for (int j = 0; j < M; j++) {
				for (int i = 0; i < N; i++) {
					if (A[i] <= B[j]) {
						count[i]++;
						break;
					}
				}
			}
			
			/* 2-2. Get max count */
			for (int i = 1; i < N; i++) {
				if (count[maxIdx] < count[i])
					maxIdx = i;
			}

			/* 3. Print result */
			sb.append("#" + tc + " " + (maxIdx + 1) + "\n");
		}
		System.out.println(sb);
	}
}
