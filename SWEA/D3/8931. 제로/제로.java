import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			
			/* 0. Initialize */
			int N = Integer.parseInt(br.readLine());
			Stack<Integer> stack = new Stack<>();
			int sum = 0;
			
			/* 1. Get numbers */
			for (int i = 0; i < N; i++) {
				int num = Integer.parseInt(br.readLine());
				if (num == 0) {
					stack.pop();
				}
				else {
					stack.push(num);
				}
			}
			
			/* 2. Calculate sum */
			while (!stack.isEmpty()) {
				sum += stack.pop();
			}
			
			/* 3. Print result */
			sb.append("#" + tc + " " + sum + "\n");
		}
		System.out.println(sb);
	}
}
