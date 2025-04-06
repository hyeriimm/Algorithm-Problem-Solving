import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append("\n");

			/* 0. Initialize */
			int N = Integer.parseInt(br.readLine());
			Set<String> set = new HashSet<>();

			/* 1. Get names */
			for (int i = 0; i < N; i++) {
				set.add(br.readLine());
			}

			/* 2. Sort */
			List<String> list = new ArrayList<>(set);
			list.sort(new Comparator<String>() {
				@Override
				public int compare(String o1, String o2) {
					if (o1.length() == o2.length()) {
						return o1.compareTo(o2);
					}
					return o1.length() - o2.length();
				}
				
			});

			/* 3. Print result */
			for (String s : list) {
				sb.append(s).append("\n");
			}
		}
		System.out.println(sb);
	}
}
