import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			/* 1. Initialize */
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String result = "";

			/* 2. Get first letter */
			while (st.hasMoreTokens()) {
				result += (char)(st.nextToken().charAt(0) - 'a' + 'A');
			}

			/* 3. Print result */
			sb.append("#" + tc + " " + result + "\n");
		}
		System.out.println(sb);
	}
}
