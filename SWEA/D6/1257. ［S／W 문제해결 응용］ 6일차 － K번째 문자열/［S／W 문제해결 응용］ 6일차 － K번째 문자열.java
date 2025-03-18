import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= TC; tc++) {
			
			/* 0. Initialize */
			int N = Integer.parseInt(br.readLine());
			String word = br.readLine();
			Set<String> sub = new HashSet<>();

			/* 1. Get substrings */
			for (int i = 0; i < word.length(); i++) {
				for (int j = i + 1; j < word.length() + 1; j++) {
					sub.add(word.substring(i, j));
				}
			}
			
			/* 2. Sort */
			Object[] list = sub.toArray();
			Arrays.sort(list);
			
			/* 3. Print result */
			if (sub.size() < N)
				sb.append("#" + tc + " none\n");
			else 
				sb.append("#" + tc + " " + list[N - 1] + "\n");
		}
		System.out.println(sb);
	}
}
