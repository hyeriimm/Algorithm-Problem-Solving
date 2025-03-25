import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			
			/* 1. Initialize */
			int N = Integer.parseInt(br.readLine());
			double sum = 0;
			
			/* 2. Get probability & money */
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				double p = Double.parseDouble(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				sum += p * x;
			}
			
			/* 3. Print result */
			sb.append("#" + tc + " " + String.format("%.6f", sum) + "\n");
		}
		System.out.println(sb);
	}
}
