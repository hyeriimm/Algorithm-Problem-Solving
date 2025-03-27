import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			
			String input = br.readLine();
			
			if ((input.charAt(input.length() - 1) - '0') % 2 == 0) {
				sb.append("#" + tc + " Even\n");
			}
			else {
				sb.append("#" + tc + " Odd\n");
			}
		}
		System.out.println(sb);
	}
}
