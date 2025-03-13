import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

	private static int N;
	private static int[] col;
	private static int result;
	
	private static void setQueen(int row) {
		
		if (!checking(row - 1)) {
			return;
		}
		
		if (row == N) {
			result++;
			return;
		}
		
		for (int j = 0; j < N; j++) {
			col[row] = j;
			
			if (checking(row))
				setQueen(row + 1);
		}
	}
	
	private static boolean checking(int row) {
		
		for (int i = 0; i < row; i++) {
			if (col[row] == col[i] || Math.abs(col[row] - col[i]) == row - i)
				return false;
		}
		return true;
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			N = Integer.parseInt(br.readLine());
			col = new int[N];
			result = 0;

			setQueen(0);

			sb.append("#" + tc + " " + result + "\n");
		}
		System.out.println(sb);
	}
}
