import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= TC; tc++) {
			sb.append("#" + tc);
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			// 2 3 4 5 6 7 
			//   3 4 5 6 7 8
			//     4 5 6 7 8 9 10
			//       5 6 7 8 9 10 11
			//         6 7 8 9 10 11 12
			
			if (N > M) {
				for (int i = N + 1 - (N - M); i <= N + 1; i++) {
					sb.append(" " + i);
				}
			} else {
				for (int i = M + 1 - (M - N); i <= M + 1; i++) {
					sb.append(" " + i);
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
