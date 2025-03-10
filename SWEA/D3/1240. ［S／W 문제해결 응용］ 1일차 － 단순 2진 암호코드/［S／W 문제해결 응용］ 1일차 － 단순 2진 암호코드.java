import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution {
	
	private static Map<String, Integer> map;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		map = new HashMap<>();
		map.put("0001101", 0);
		map.put("0011001", 1);
		map.put("0010011", 2);
		map.put("0111101", 3);
		map.put("0100011", 4);
		map.put("0110001", 5);
		map.put("0101111", 6);
		map.put("0111011", 7);
		map.put("0110111", 8);
		map.put("0001011", 9);
		
		for (int tc = 1; tc <= T; tc++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int validate = 0;
			int result = 0;
			
			for (int i = 0; i < N; i++) {
				String input = br.readLine();
				
				/* 1. Find code */
				if (input.contains("1") && result == 0) {
					int idx = 0;
					for (int j = M - 1; j >= 0; j--) {
						if (input.charAt(j) == '1') {
							idx = j - 55;
							break;
						}
					}
					
					/* 2. Decode to number */
					for (int j = 0; j < 8; j++) {
						String code = input.substring(idx + j * 7, idx + (j + 1) * 7);
						int num = map.get(code);
						
						result += num;
						
						if (j % 2 == 0) validate += num * 3;
						else validate += num;
					}
				}
			}

			/* 3. Print result */
			if (validate % 10 == 0)
				sb.append("#" + tc + " " + result + "\n");
			else
				sb.append("#" + tc + " 0\n");
		}
		System.out.println(sb);
	}
}
