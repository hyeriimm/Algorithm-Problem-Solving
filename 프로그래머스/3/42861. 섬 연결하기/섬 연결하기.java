import java.util.*;

class Solution {
    
    int N;
    int[] parent;
    
    class Edge implements Comparable<Edge> {
        
		public int from;
		public int to;
		public int weight;
		
		public Edge(int start, int end, int weight) {
			this.from = start;
			this.to = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}
    }
    
    void makeSet() {
        parent = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }
    }
    int find(int a) {
        if (parent[a] == a) {
            return a;
        }
        return parent[a] = find(parent[a]);
    }
    
    boolean union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);
        
        if (aRoot == bRoot) return false;
        
        parent[bRoot] = aRoot;
        return true;
    }
    
    public int solution(int n, int[][] costs) {
        
        int E = costs.length;
        Edge[] edges = new Edge[E];
        N = n;
        
        for (int i = 0; i < E; i++) {
            edges[i] = new Edge(costs[i][0], costs[i][1], costs[i][2]);
        }
        
        Arrays.sort(edges);
        
        makeSet();
        
        int answer = 0;
        int count = 0;
        
        for (Edge edge : edges) {
            
            if (union(edge.from, edge.to)) {
                answer += edge.weight;
                
                if (++count == N - 1) break;
            }
        }
        
        return answer;
    }
}