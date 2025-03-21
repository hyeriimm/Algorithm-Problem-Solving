import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	private static int N;
	private static int[][] adjMatrix;
	private static boolean[] visited;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			/* 0. Initialize */
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			adjMatrix = new int[N][N];
			int minCC = Integer.MAX_VALUE;

			/* 1. Get adjacency matrix */
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					adjMatrix[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			/* 2. BFS */
			for (int i = 0; i < N; i++) {
				visited = new boolean[N];
				int cci = bfs(i);
				if (minCC > cci) minCC = cci;
			}
			
			/* 3. Print result */
			sb.append("#" + tc + " " + minCC + "\n");
		}
		System.out.println(sb);
	}

	private static int bfs(int start) {

		Queue<Integer> queue = new ArrayDeque<>();
		int level = 0;
		int CC = 0;

		queue.offer(start);
		visited[start] = true;

		while (!queue.isEmpty()) {

			int size = queue.size();

			for (int k = 0; k < size; k++) {
				
				int v = queue.poll();
				CC += level;

				for (int w = 0; w < N; w++) {
					if (!visited[w] && adjMatrix[v][w] == 1) {
						queue.offer(w);
						visited[w] =true;
					}
				}
			}
			level++;
		}
		
		return CC;
	}
}
