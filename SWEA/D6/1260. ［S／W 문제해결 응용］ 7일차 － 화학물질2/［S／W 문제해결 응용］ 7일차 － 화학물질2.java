import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	private static int N;
	private static int[][] matrix;
	private static ArrayList<Matrix> list;
	private static ArrayList<Matrix> sortedList;
	private static int[][] dp;

	private static class Matrix {
		int row;
		int col;

		public Matrix(int row, int col) {
			super();
			this.row = row;
			this.col = col;
		}

		@Override
		public String toString() {
			return "Matrix [row=" + row + ", col=" + col + "]";
		}
	}

	private static void findSubMatrix() {
		int i = 0;
		int j = 0;
		while (i < N) {

			int p = 0;
			int q = 0;

			for (j = 0; j < N; j++)
				if (matrix[i][j] > 0)
					break;

			if (j == N) {
				i++;
				continue;
			}

			for (q = j; q < N; q++) {
				if (matrix[i][q] == 0) break;
				else matrix[i][q] = 0;
			}

			for (p = i + 1; p < N; p++) {
				if (matrix[p][j] == 0) break;
				else {
					for (int k = j; k < q; k++)
						matrix[p][k] = 0;
				}
			}

			list.add(new Matrix(p - i, q- j));
		}
	}

	private static void findOrder() {
		
		sortedList = new ArrayList<>();
		sortedList.add(list.remove(0));
		
		while (!list.isEmpty()) {
			
			for (int i = 0; i < list.size(); i++) {
				Matrix m = list.get(i);
				
				if (m.col == sortedList.get(0).row) {
					sortedList.add(0, list.remove(i));
					break;
				}
				else if (m.row == sortedList.get(sortedList.size() - 1).col) {
					sortedList.add(list.remove(i));
					break;
				}
			}
		}
	}
	
	private static int minMultiple() {
		
		int size = sortedList.size();
		dp = new int[size][size];
		
		for (int len = 2; len <= size; len++) {
			for (int i = 0; i <= size - len; i++) {
				int j = i + len - 1;
				dp[i][j] = Integer.MAX_VALUE;
				
				for (int k = i; k < j; k++) {
					int cost = dp[i][k] + dp[k + 1][j] 
							+ sortedList.get(i).row * sortedList.get(k).col * sortedList.get(j).col;
					dp[i][j] = Math.min(dp[i][j], cost);
				}
			}
		}
		
		return dp[0][size - 1];
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			/* 0. Initialize */
			N = Integer.parseInt(br.readLine());
			matrix = new int[N][N];
			list = new ArrayList<>();

			/* 1. Get matrix */
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					matrix[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			/* 2-1. Find sub matrix */
			findSubMatrix();

			/* 2-2. Get order to multiple matrixes */
			findOrder();

			/* 2-3. Minimum Matrix Multiplication */
			int result = minMultiple();

			/* 3. Print result */
			sb.append("#" + tc + " " + result + "\n");
		}
		System.out.println(sb);
	}
}
