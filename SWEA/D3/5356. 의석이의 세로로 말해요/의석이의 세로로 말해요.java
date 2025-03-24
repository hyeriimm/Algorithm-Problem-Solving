import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

	private static int N = 5;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			String[] word = new String[N];
			int length = 0;
			String result = "";

			for (int i = 0; i < N; i++) {
				word[i] = br.readLine();
				if (length < word[i].length())
					length = word[i].length();
			}

			for (int j = 0; j < length; j++) {
				for (int i = 0; i < N; i++) {
					if (word[i].length() > j)
						result += word[i].charAt(j);
				}
			}

			sb.append("#" + tc + " " + result + "\n");
		}
		System.out.println(sb);
	}
}
