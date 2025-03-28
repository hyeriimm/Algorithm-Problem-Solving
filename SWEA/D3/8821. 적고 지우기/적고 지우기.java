import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			
			/* 0. Initialize */
			String input = br.readLine();
			boolean[] check = new boolean[10];
			int count = 0;
			
			/* 1. Write & Erase */
			for (int i = 0; i < input.length(); i++) {
				int num = input.charAt(i) - '0';
				if (check[num]) check[num] = false; // erase
				else check[num] = true; // write
			}
			
			/* 2. Count numbers */
			for (int i = 0; i < 10; i++) {
				if (check[i]) count++;
			}
			
			/* 3. Print result */
			sb.append("#" + tc + " " + count + "\n");
		}
		System.out.println(sb);
	}
}
