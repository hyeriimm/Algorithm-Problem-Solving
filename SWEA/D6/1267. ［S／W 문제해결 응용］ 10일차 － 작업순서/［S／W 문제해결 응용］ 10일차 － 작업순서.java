import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	private static int V;
	private static int E;
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
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 1; tc <= 10; tc++) {
			sb.append("#" + tc + " ");
			
			StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			adjList = new Node[V + 1];
			inDegree = new int[V + 1]; // 각 노드의 진입 차수 기록
			
			// 1. 그래프의 정보를 인접리스트에 저장
			int from, to = 0;
			st = new StringTokenizer(br.readLine().trim(), " ");
			for (int i = 0; i < E; i++) {
				from = Integer.parseInt(st.nextToken());
				to = Integer.parseInt(st.nextToken());
				adjList[from] = new Node(to, adjList[from]);
				inDegree[to]++;
			}
			
			// 2. 위상정렬 수행
			List<Integer> list = topologySort();
			
			if (list.size() == V) {
				for (Integer vertex : list) {
					sb.append(vertex + " ");
				}
				sb.append("\n");
			}
			else {
				System.out.println("cycle");
			}
		}
		System.out.println(sb);
	}
	
	private static List<Integer> topologySort() {
		
		List<Integer> orderList = new ArrayList<>();
		
		Queue<Integer> queue = new ArrayDeque<>();
		for (int i = 1; i <=V; i++) {
			
			// 1. 진입 차수가 0인 노드(시작점)를 큐에 모두 넣는다
			if (inDegree[i] == 0) {
				queue.offer(i);
			}
		}
		
		while (!queue.isEmpty()) {
			
			// 2. 큐에서 진입 차수가 0인 노드를 꺼내어 자신과 인접한 노드의 간선을 제거한다
			Integer cur = queue.poll();
			orderList.add(cur);
			
			for (Node temp = adjList[cur]; temp != null; temp = temp.link) {
				
				// 2. 인접한 노드의 진입 차수를 1 감소시킨다
				if (--inDegree[temp.vertex] == 0) {
					
					// 3. 간선 제거 후 진입차수가 0이 된 노드를 큐에 넣는다
					queue.offer(temp.vertex);
				}
			}
		}
		
		return orderList;
	}
}
