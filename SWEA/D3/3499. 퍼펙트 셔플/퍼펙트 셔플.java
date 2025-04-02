import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#" + tc);
			
			int N = Integer.parseInt(br.readLine());
			String[] strings = br.readLine().split(" ");
			
			for (int i = 0; i < (N + 1) / 2; i++) {
				sb.append(" " + strings[i]);
				if (i + (N + 1) / 2 < N)
					sb.append(" " + strings[i + (N + 1) / 2]);
			}

			sb.append("\n");
		}
		System.out.println(sb);
	}
}
