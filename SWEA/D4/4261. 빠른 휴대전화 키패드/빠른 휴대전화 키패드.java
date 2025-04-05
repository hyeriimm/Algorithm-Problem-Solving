import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		char[] key = { '2', '2', '2', '3', '3', '3',
				'4', '4', '4', '5', '5', '5', 
				'6', '6', '6', '7', '7', '7', '7',
				'8', '8', '8', '9', '9', '9', '9' };
		
		for (int tc = 1; tc <= T; tc++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			String S = st.nextToken();
			int N = Integer.parseInt(st.nextToken());

			String[] words = br.readLine().split(" " );
			int count = 0;
			
			for (String w : words) {
				boolean isValid = true;
				if (w.length() != S.length()) continue;
				
				for (int j = 0; j < S.length(); j++) {
					int c = w.charAt(j) - 'a';
					if (key[c] != S.charAt(j)) {
						isValid = false;
						break;
					}
				}
				
				if (isValid) count++;
			}
			
			sb.append("#" + tc + " " + count + "\n");
		}
		System.out.println(sb);
	}
}
