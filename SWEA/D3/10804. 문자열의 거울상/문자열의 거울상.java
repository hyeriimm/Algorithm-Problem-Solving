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
			
			/* 1. Get input string */
			String input = br.readLine();
			String result = "";
			
			/* 2. Get mirrored string */
			for (int i = input.length() - 1; i >= 0; i--) {
				char c = input.charAt(i);
				if (c == 'b') result += 'd';
				else if (c == 'd') result += 'b';
				else if (c == 'p') result += 'q';
				else if (c == 'q') result += 'p';
			}
			
			/* 3. Print result */
			sb.append("#" + tc + " " + result + "\n");
		}
		System.out.println(sb);
	}
}
