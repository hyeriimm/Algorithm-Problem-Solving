import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	private static int N;
	private static int M;
	private static ArrayList<Integer>[] adjList;
	private static boolean[] visited;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			/* 0. Initialize */
			StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			adjList = new ArrayList[N + 1];
			visited = new boolean[N + 1];
			int count = 0;

			for (int i = 1; i <= N; i++) {
				adjList[i] = new ArrayList<>();
			}

			/* 1. Make adjacency list */
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine().trim(), " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				adjList[a].add(b);
				adjList[b].add(a);
			}

			/* 2. Find number of component */
			for (int i = 1; i <= N; i++) {
				if (!visited[i]) {
					count++;
					bfs(i);
				}
			}

			/* 3. Print result */
			sb.append("#" + tc + " " + count + "\n");
		}
		System.out.println(sb);
	}

	private static void bfs(int start) {

		Queue<Integer> queue = new ArrayDeque<>();
		
		queue.offer(start);
		visited[start] = true;

		while (!queue.isEmpty()) {
			int v = queue.poll();

			for (int w : adjList[v]) {
				if (!visited[w]) {
					queue.offer(w);
					visited[w] = true;
				}
			}
		}
	}
}
