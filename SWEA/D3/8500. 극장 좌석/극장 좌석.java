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
			int sum = N;
			int max = 0;
			
			/* 2. Get seats & Calculate sum */
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				int num = Integer.parseInt(st.nextToken());
				if (max < num) max = num;
				sum += num;
			}
			sum += max;
			
			/* 3. Print result */
			sb.append("#" + tc + " " + sum + "\n");
		}
		System.out.println(sb);
	}
}
