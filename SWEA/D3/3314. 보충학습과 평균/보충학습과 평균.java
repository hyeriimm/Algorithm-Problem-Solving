import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int sum = 0;
			int count = 0;
			
			while (st.hasMoreTokens()) {
				count++;
				int num = Integer.parseInt(st.nextToken());
				if (num > 40) sum += num;
				else sum += 40;
			}
			
			sb.append("#" + tc + " " + sum / count + "\n");
		}
		System.out.println(sb);
	}
}
