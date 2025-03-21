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
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int P = Integer.parseInt(st.nextToken());
			int num = N / P;
			long result = 1;
			
			/* 2. Calculate result */
			for (int i = 0; i < N % P; i++) {
				result *= (num + 1);
			}
			for (int i = N % P; i < P; i++) {
				result *= num;
			}
			
			/* 3. Print result */
			sb.append("#" + tc + " " + result + "\n");
		}
		System.out.println(sb);
	}
}
