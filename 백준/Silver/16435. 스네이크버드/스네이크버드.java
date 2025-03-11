import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		/* 0. Initialize */
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int[] H = new int[N];

		/* 1. Get heights of fruits */
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			H[i] = Integer.parseInt(st.nextToken());
		}

		/* 1-1 Sort in ascending order */
		Arrays.sort(H);

		/* 2. Eat fruits */
		for (int i = 0; i < N; i++) {
			if (H[i] > L) break;
			L++;
		}

		/* 3. Print result */
		System.out.println(L);
	}
}
