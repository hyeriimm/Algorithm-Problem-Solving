import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			
			/* 0. Initialize */
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			int[] customer = new int[N];
			boolean canServe = true;
			int count = 0;
			
			/* 1-1. Get customers */
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				customer[i] = Integer.parseInt(st.nextToken());
			}

			/* 1-2. Sort customers in ascending order */
			Arrays.sort(customer);
			
			/* 2. Check if bread can be served */
			for (int cnt = 0; cnt < N; cnt++) {
				if (cnt + 1 > customer[cnt] / M * K) {
					canServe = false;
					break;
				}
			}
			
			/* 3. Print result */
			if (canServe)
				sb.append("#" + tc + " Possible\n");
			else 
				sb.append("#" + tc + " Impossible\n");
		}
		System.out.println(sb);
	}
}
