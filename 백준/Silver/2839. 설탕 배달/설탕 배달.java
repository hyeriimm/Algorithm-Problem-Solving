import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int count = -1;

		for (int i = N / 5; i >= 0; i--) {
			int remain = N - 5 * i;

			if (remain % 3 == 0) {
				count = i + remain / 3;
				break;
			}
		}
		System.out.println(count);
	}
}
