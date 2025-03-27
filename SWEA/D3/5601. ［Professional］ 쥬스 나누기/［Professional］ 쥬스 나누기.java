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

			for (int i = 0; i < N; i++) {
				sb.append(" 1/" + N);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
