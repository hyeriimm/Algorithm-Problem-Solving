import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	
	private static int N;
	private static int[] nums;
	private static int change;
	private static int maxMoney;
	private static ArrayList<String> visited;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			/* 0. Initialize */
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String input = st.nextToken();
			N = input.length();
			nums = new int[N];
			change = Integer.parseInt(st.nextToken());
			maxMoney = 0;
			visited = new ArrayList<>();

			/* 1. Get numbers */
			for (int i = 0; i < N; i++) {
				nums[i] = input.charAt(i) -'0';
			}
			
			/* 2. Back Tracking */
			dfs(0);

			/* 3. Print result */
			sb.append("#" + tc + " " + maxMoney + "\n");
		}
		System.out.println(sb);
	}
	
	private static void dfs(int cnt) {
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++)
			sb.append(nums[i]);
		
		if (cnt == change) {
			int result = Integer.parseInt(sb.toString());
			if (maxMoney < result) maxMoney = result;
			return;
		}
		
		// pruning
		String key = sb + " " + cnt;
		if (visited.contains(key)) {
			return;
		}
		visited.add(key);
		
		for (int i = 0; i < N - 1; i++) {
			for (int j = i + 1; j < N ; j++) {
				int temp = nums[i];
				nums[i] = nums[j];
				nums[j] = temp;
				
				dfs(cnt + 1);
				
				nums[j] = nums[i];
				nums[i] = temp;
			}
		}
	}
}
