import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	private static int N;
	private static int M;
	private static char[][] tiles;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc);

			/* 0. Initialize */
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken()); 
			tiles = new char[N][M];

			/* 1. Get tiles */
			for (int i = 0; i < N; i++) {
				tiles[i] = br.readLine().toCharArray();
			}

			/* 3. Print result */
			if (changeTile()) sb.append(" YES\n");
			else sb.append(" NO\n");
		}
		System.out.println(sb);
	}
	
	/* 2. Change broken tiles */
	private static boolean changeTile() {
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (tiles[i][j] == '#') {
					
					tiles[i][j] = '.';
					
					if (j + 1 == M || tiles[i][j + 1] != '#') return false;
					tiles[i][j + 1] = '.';
					
					if (i + 1 == N || tiles[i + 1][j] != '#' || tiles[i + 1][j + 1] != '#') return false;
					tiles[i + 1][j] = '.';
					tiles[i + 1][j + 1] = '.';
				}
			}
		}
		
		return true;
	}
}
