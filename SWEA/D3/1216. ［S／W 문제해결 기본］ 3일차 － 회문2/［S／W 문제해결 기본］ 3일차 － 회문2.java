import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

	private static int N = 100;
	private static char[][] arr;
	
	private static boolean solve(int l) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j <= (N - l); j++) {
				if (solveRow(i, j, l) || solveColumn(j, i, l))
					return true;
			}
		}
		return false;
	}
	
	private static boolean solveRow(int i, int j, int l) {
		for (int k = 0; k < l / 2; k++) {
			if (arr[i][j + k] != arr[i][j + l - 1 - k]) return false;
		}
		return true;
	}
	
	private static boolean solveColumn (int i, int j, int l) {
		for (int k = 0; k < l / 2; k++) {
			if (arr[i + k][j] != arr[i + l - 1 - k][j]) return false;
		}
		return true;
	}
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 1; tc <= 10; tc++) {
			
			/* 0. Initialize */
			int T = Integer.parseInt(br.readLine());
			arr = new char[N][N];
			
			/* 1. Count row */
			for (int i = 0; i < N; i++) {
				arr[i] = br.readLine().toCharArray();
			}
			
			/* 2. Count column */
			for (int i = N; i > 0; i--) {
				if (solve(i)) {
					System.out.println("#" + T + " " + i);
					break;
				}
			}
		}
	}
}
