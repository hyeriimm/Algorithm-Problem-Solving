import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	private static int N;
	private static int M;
	private static Node[] adjList;
	private static int[] inDegree;
	
	private static class Node {
		
		int vertex;
		Node link;

		public Node(int vertex, Node link) {
			super();
			this.vertex = vertex;
			this.link = link;
		}
	}
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		/* 0. Initialize */
		StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		adjList = new Node[N + 1];
		inDegree = new int[N + 1];
		
		/* 1. Get adjacency list */
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine().trim(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			adjList[from] = new Node(to, adjList[from]);
			inDegree[to]++;
		}

		/* 2. Topology Sort */
		topologySort();
	}
	
	/* topology sort */
	private static void topologySort() {
		
		List<Integer> orderList = new ArrayList<>();
		Queue<Integer> queue = new ArrayDeque<>();
		
		for (int i = 1; i <= N; i++) {
			if (inDegree[i] == 0)
				queue.offer(i);
		}
		
		while (!queue.isEmpty()) {
			int curr = queue.poll();
			orderList.add(curr);
			
			for (Node temp = adjList[curr]; temp != null; temp = temp.link) {
				if (--inDegree[temp.vertex] == 0) {
					queue.offer(temp.vertex);
				}
			}
		}

		/* 3. Print result */
		StringBuilder sb = new StringBuilder();
		for (int vertex : orderList) {
			sb.append(vertex + " ");
		}
		System.out.println(sb);
	}
}
