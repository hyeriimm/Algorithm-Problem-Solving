import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			
			/* 0. Initialize */
			String input = br.readLine();
			char prev = '.';
			int count = 0;
			
			for (int i = 0; i < input.length(); i++) {
				char c = input.charAt(i);
				if (c == ')') {
					if (prev == '(' || prev == '|') count++;
				}
				if (c == '|' && prev == '(') count++;
				prev = c;
			}
			
			/* 3. Print result */
			sb.append("#" + tc + " " + count + "\n");
		}
		System.out.println(sb);
	}

}
