import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	private static int N;
	private static int L;
	private static int[] T;
	private static int[] K;
	private static int maxTaste;
	
	/* generate subset of ingredients */
	private static void generateSubSet(int cnt, int calorie, int taste) {
	
		// exceed calorie
		if (calorie > L) return;
		
		if (cnt == N) {
			if (maxTaste < taste)
				maxTaste = taste;
			return;
		}
		
		generateSubSet(cnt + 1, calorie + K[cnt], taste + T[cnt]);
		generateSubSet(cnt + 1, calorie, taste);
	}

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= TC; tc++) {
			
			/* 0. Initialize */
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			T = new int[N];
			K = new int[N];
			maxTaste = Integer.MIN_VALUE;
			
			/* 1. Get Taste & Calorie of ingredients */
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				T[i] = Integer.parseInt(st.nextToken());
				K[i] = Integer.parseInt(st.nextToken());
			}
			
			/* 2. Generate Subset */
			generateSubSet(0, 0 , 0);
			
			/* 3. Print result */
			sb.append("#" + tc + " " + maxTaste + "\n");
		}
		System.out.println(sb);
	}
}
