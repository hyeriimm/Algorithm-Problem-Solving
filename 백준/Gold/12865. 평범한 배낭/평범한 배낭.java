import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static int N;
	private static int K;
	private static int[] W;
	private static int[] V;
	private static int[][] D;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		/* 0. Initialize */
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		W = new int[N + 1];
		V = new int[N + 1];
		D = new int[N + 1][K + 1];
		
		/* 1. Get each weigh & value */
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			W[i] = Integer.parseInt(st.nextToken());
			V[i] = Integer.parseInt(st.nextToken());
		}
		
		/* 2. Knapsack */
		for (int i = 1; i <= N; i++) {
			for (int w = 1; w <= K; w++) {
				if (W[i] > w)
					D[i][w] = D[i - 1][w];
				else
					D[i][w] = Math.max(V[i] + D[i - 1][w - W[i]], D[i - 1][w]);
			}
		}
		
		/* 3. Print result */
		sb.append(D[N][K]);
		System.out.println(sb);
	}
}
