import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			
			int N = Integer.parseInt(br.readLine());
			int left = N / 2;
			int right = N / 2;
			int sum = 0;
			
			for (int i = 0; i < N; i++) {
				String input = br.readLine();
				
				for (int j = left; j <= right; j++) {
					sum += input.charAt(j) - '0';
				}
				
				if (i < N / 2) {
					left--;
					right++;
				} else {
					left++;
					right--;
				}
			}
			
			sb.append("#" + tc + " " + sum + "\n");
		}
		System.out.println(sb);
	}
}
