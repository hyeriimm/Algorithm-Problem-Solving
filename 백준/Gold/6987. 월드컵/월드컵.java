import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static int[][] result;
	private static boolean isValid;

	private static void match(int t1, int t2) {

		if (t2 == 6) {
			t1++;
			t2 = t1 + 1;
		}

		if (t1 == 5) {
			for (int i = 0; i < 6; i++) {
				for (int j = 0; j < 3; j++) {
					if (result[i][j] != 0)
						return;
				}
			}
			isValid = true;
		}
		if (isValid) return;

		// t1 win
		if (result[t1][0] != 0 && result[t2][2] != 0) {
			result[t1][0]--;
			result[t2][2]--;
			match(t1, t2 + 1);
			result[t1][0]++;
			result[t2][2]++;
		}

		// tie
		if (result[t1][1] != 0 && result[t2][1] != 0) {
			result[t1][1]--;
			result[t2][1]--;
			match(t1, t2 + 1);
			result[t1][1]++;
			result[t2][1]++;
		}

		// t1 lose
		if (result[t1][2] != 0 && result[t2][0] != 0) {
			result[t1][2]--;
			result[t2][0]--;
			match(t1, t2 + 1);
			result[t1][2]++;
			result[t2][0]++;
		}
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int tc = 0; tc < 4; tc++) {

			isValid = false;
			result = new int[6][3];
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			/* 1. Get result */
			for (int i = 0; i < 6; i++) {
				for (int j = 0; j < 3; j++) {
					result[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			/* 2. Simulate match */
			match(0, 1);

			/* 3. Print result */
			if (isValid) System.out.print("1 ");
			else System.out.print("0 ");
		}
	}
}
