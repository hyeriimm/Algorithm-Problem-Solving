import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

            /* 0. Initialize */
			int N = Integer.parseInt(br.readLine());
			Queue<Integer> A = new ArrayDeque<>();
			Queue<Integer> B = new ArrayDeque<>();
			char[] selected = new char[N + 1];
			int turn = 1;

            /* 1. Get player preference */
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				A.offer(Integer.parseInt(st.nextToken()));
			}
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				B.offer(Integer.parseInt(st.nextToken()));
			}

            /* 2. Choose player */
			for (int i = 0; i < N; i++) {
				if (turn == 1) {
					while (!A.isEmpty()) {
						int player = A.poll();
						if (selected[player] == 0) {
							selected[player] = 'A';
							turn = 2;
							break;
						}
					}
				} else {
					while (!B.isEmpty()) {
						int player = B.poll();
						if (selected[player] == 0) {
							selected[player] = 'B';
							turn = 1;
							break;
						}
					}
				}
			}
			
			/* 3. Print result */
			for (int i = 1; i <= N; i++) {
				sb.append(selected[i]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
