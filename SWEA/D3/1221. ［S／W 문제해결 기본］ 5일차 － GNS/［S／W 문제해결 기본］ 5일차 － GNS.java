import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Solution {

	private static String str[] = { "ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN" };
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= 10; tc++) {
			sb.append("#" + tc);
			
			/* 0. Initialize */
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			st.nextToken();
			int N = Integer.parseInt(st.nextToken());
            
            /* 1. Map for counting */
			HashMap<String, Integer> map = new HashMap<>();
            for (String s : str) {
				map.put(s, 0);
			}
			
			/* 2. Count numbers */
			int[] count = new int[10];
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				String s = st.nextToken();
				map.replace(s, map.get(s) + 1);
			}
			
			/* 3. Print numbers */
			for (String s : str) {
				for (int i = 0; i < map.get(s); i++)
					sb.append(" " + s);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
