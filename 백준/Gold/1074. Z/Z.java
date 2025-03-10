import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static int divide(int row, int col, int n) {
		
		if (n == 1) {
			if (row == 0) {
				if (col == 0) return 0;
				else if (col == 1) return 1;
			}
			else if (row == 1) {
				if (col == 0) return 2;
				else if (col == 1) return 3;
			}
		}
		
		int half = (int)Math.pow(2, n - 1);
		
		if (row < half) {
			if (col < half)
				return divide(row, col, n - 1);
			else
				return divide(row, col - half, n - 1) + half * half;
		}
		else {
			if (col < half)
				return divide(row - half, col, n - 1) + half * half * 2;
			else
				return divide(row - half, col - half, n - 1) + half * half * 3;
		}
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /* 1. Get values */
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

        /* 2. Divide & Conquer */
		int count = divide(r, c, N);

		/* 3. Print result */
		System.out.println(count);
	}
}
