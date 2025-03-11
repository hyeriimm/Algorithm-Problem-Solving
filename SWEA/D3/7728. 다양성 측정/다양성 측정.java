import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			
			String input = br.readLine();
			int N = input.length();
			boolean[] hasNum = new boolean[10];
			int result = 0;
			
			for (int i = 0; i < N; i++) {
				hasNum[input.charAt(i) - '0'] = true;
			}
			
			for (int i = 0; i < 10; i ++) {
				if (hasNum[i]) result++;
			}
			
			sb.append("#" + tc + " " + result + "\n");
		}
		System.out.println(sb);
	}
}
