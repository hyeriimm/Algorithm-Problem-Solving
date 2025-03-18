import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	private static int N;
	private static char[][] map;
	private static int[][] count;
	
	/* BFS */
	private static void move(int r, int c, char m) {
		
		if (r == N -1 && c == N - 1) {
			return;
		}
		
		if (m == '-') {
			if (c + 1 < N && map[r][c + 1] == '0') {
				count[r][c + 1]++;
				move(r, c + 1, '-');
				
				if (r + 1 < N && map[r + 1][c] == '0' && map[r + 1][c + 1] == '0') {
					count[r + 1][c + 1]++;
					move(r + 1, c + 1, '/');
				}
			}
		}
		else if (m == '|') {
			if (r + 1 < N && map[r + 1][c] == '0') {
				count[r + 1][c]++;
				move(r + 1, c, '|');
				
				if (c + 1 < N && map[r][c + 1] == '0' && map[r + 1][c + 1] == '0') {
					count[r + 1][c + 1]++;
					move(r + 1, c + 1, '/');
				}
			}
		}
		else {
			if (c + 1 < N && map[r][c + 1] == '0') {
				count[r][c + 1]++;
				move(r, c + 1, '-');
			}
			if (r + 1 < N && map[r + 1][c] == '0') {
				count[r + 1][c]++;
				move(r + 1, c, '|');
			}
			if (r + 1 < N && c + 1 < N && map[r + 1][c + 1] == '0'
					&& map[r][c + 1] == '0' && map[r + 1][c] == '0') {
				count[r + 1][c + 1]++;
				move(r + 1, c + 1, '/');
			}
		}
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		/* 0. Initialize */
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		count = new int[N][N];
		
		/* 1. Get map */
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = st.nextToken().charAt(0);
			}
		}
		
		/* 2. BFS */
		move(0, 1, '-');
		
		/* 3. Print result */
		sb.append(count[N - 1][N - 1]);
		System.out.println(sb);
	}
}
