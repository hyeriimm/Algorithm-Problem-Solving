import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution {
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			int N = Integer.parseInt(br.readLine());
			ArrayList<Integer> height = new ArrayList<>();
			
			/* 1. Get heights */
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				height.add(Integer.parseInt(st.nextToken()));
			}

			/* 2-1. Sort heights in reverse order */
			Collections.sort(height);
			Collections.reverse(height);

			int day = 0;
			int high = height.get(0);
			while (height.remove((Integer)high)); // remove highest

			/* 2-2. Water & Count days */
			while (!height.isEmpty()) {
				
				day++;
				
				if (day % 2 == 1) { // day - odd
					for (int i = 0; i < height.size(); i++) {
						if (high - height.get(i) == 1) {
							height.remove(i);
							break;
						}
						else if (high - height.get(i) != 2) {
							height.set(i, height.get(i) + 1);
							break;
						}
						// else (high - height.get(i) == 2) leave it for even day
					}
				} else { // day- even
					for (int i = 0; i < height.size(); i++) {
						if (high - height.get(i) == 2) {
							height.remove(i);
							break;
						}
						else if (high - height.get(i) > 1) {
							height.set(i, height.get(i) + 2);
							break;
						}
						// else (high - height.get(i) == 1) leave it for odd day
					}
				}

			}

			/* 3. Print result */
			sb.append("#" + tc + " " + day + "\n");
		}
		System.out.println(sb);
	}
}
