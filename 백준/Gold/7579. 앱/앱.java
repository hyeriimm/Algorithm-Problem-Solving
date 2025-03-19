import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	private static int N;
	private static int M;
	private static int[] m;
	private static int[] c;
	private static int[][] D;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		/* 0. Initialize */
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		m = new int[N + 1];
		c = new int[N + 1];
		int minMemory = 0;
		int maxCost = 0;
		
		/* 1. Get each memory & cost */
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= N; i++) {
			m[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= N; i++) {
			c[i] = Integer.parseInt(st.nextToken());
			maxCost += c[i];
		}
		D = new int[N + 1][maxCost + 1];
		
		/* 2. Knapsack */
		for (int i = 1; i <= N; i++) {
			for (int cost = 0; cost <= maxCost; cost++) {
				if (c[i] > cost)
					D[i][cost] = D[i - 1][cost];
				else
					D[i][cost] = Math.max(m[i] + D[i - 1][cost - c[i]], D[i - 1][cost]);
			}
		}
		
		/* 3. Find minimum cost */
		for (int cost = 0; cost <= maxCost; cost++) {
			if (D[N][cost] >= M) { // can get enough memory
				sb.append(cost);
				break;
			}
		}
		System.out.println(sb);
	}
}
