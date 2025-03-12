import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			
			int max = 0;
			int min = Integer.MAX_VALUE;
			
			StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
			for (int i = 0; i < 10; i++) {
				
				int N = Integer.parseInt(st.nextToken());
				int sum = 0;
				
				while (N > 0) {
					sum += N % 10;
					N /= 10;
				}
				
				if (max < sum) max = sum;
				if (min > sum) min = sum;
			}
			
			sb.append("#" + tc + " " + max + " " + min + "\n");
		}
		System.out.println(sb);
	}
}
