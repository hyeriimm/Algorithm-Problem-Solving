import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {

	private static int N;
	private static double E;
	private static int[] X;
	private static int[] Y;
	private static boolean[] visited;
	private static int[] parents;
	private static long[][] dist;
	
	private static class Edge implements Comparable<Edge> {

		int from;
		int to;
		long dist;
		
		public Edge(int from, int to, long dist) {
			super();
			this.from = from;
			this.to = to;
			this.dist = dist;
		}

		@Override
		public int compareTo(Edge o) {
			return Long.compare(this.dist, o.dist);
		}
	}
	
	private static void makeSet() {

		parents = new int[N];
		
		for (int i = 0; i < N; i++) {
			parents[i] = i;
		}
	}
	
	private static int findSet(int a) {
		
		if (parents[a] == a)
			return a;
		return parents[a] = findSet(parents[a]);
	}
	
	private static boolean union(int a, int b) {
		
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		
		if (aRoot == bRoot) return false;
		
		parents[bRoot] = aRoot;
		return true;
	}
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			
			/* 0. Initialize */
			N = Integer.parseInt(br.readLine());
			X = new int[N];
			Y = new int[N];
			visited = new boolean[N];
			parents = new int[N];
			
			/* 1. Get positions */
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				X[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				Y[i] = Integer.parseInt(st.nextToken());
			}
			E = Double.parseDouble(br.readLine());
			
			/* 1-2. Calculate distances */
			PriorityQueue<Edge> pq = new PriorityQueue<>();
			
			for (int i = 0; i < N - 1; i++) {
				for (int j = i + 1; j < N; j++) {
					long d = (long)(X[i] - X[j]) * (X[i] - X[j]) + (long)(Y[i] - Y[j]) * (Y[i] - Y[j]);
					pq.offer(new Edge(i, j, d));
				}
			}
			
			/* 2. Kruskal */
			double envFee = 0;
			int cnt = 0;
			
			makeSet();
			
			while (!pq.isEmpty()) {
				Edge e = pq.poll();
				
				if (union(e.from, e.to)) {
					envFee += e.dist * E;
					
					if (++cnt == N - 1) {
						break;
					}
				}
				
			}
			
			/* 3. Print result */
			sb.append("#" + tc + " " + String.format("%.0f", envFee) + "\n");
		}
		System.out.println(sb);
	}
}
