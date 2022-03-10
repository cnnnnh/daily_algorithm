import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Double.MIN_VALUE : 4.9E-324
// 0 < Double.MIN_VALUE < 1
// double d = -1000000001 은 가능함. 왜?
public class Main {
	
	static int N;
	static double g;
	static int[] building;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		
		building = new int [N+1];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			building[i] = Integer.parseInt(st.nextToken());
		}
		
		int result;
		int max = Integer.MIN_VALUE;
		
		for (int i = 1; i <= N; i++) {
			result = 0;
			// 맨 왼쪽 건물일 때, 오른쪽에 있는 건물들만 비교
			if (i == 1) result += compare(1, true);
			// 맨 오른쪽 건물일 때, 왼쪽에 있는 건물들만 비교
			else if (i == N) result += compare(N, false);
			// 현재 지점에서의 왼쪽, 오른쪽 건물을 비교 후 result에 더함
			else {
				result += compare(i, false);
				result += compare(i, true);
			}
			// 최댓값 갱신
			if (result > max) max = result;
		}

		System.out.println(max);
	}
	

	
	static int compare(int index, boolean flag) {
		int cnt = 0;
		double temp;
		// 건물의 왼쪽 탐색
		if (!flag) {
			g = 1000000001;
			for (int i = index-1; i >= 1; i--) {
				// 기울기 구하기
				temp = (double)(building[index] - building[i]) / (double)(index - i);
				// 이전의 기울기보다 작다면 보이는 건물
				// 기울기 갱신해주고 건물 개수 ++
				if (g > temp) {
					g = temp;
					cnt++;
				}
			}
		}
		// 건물의 오른쪽 탐색
		else {
			g = -1000000001;
			for (int i = index+1; i <= N; i++) {
				// 기울기 구하기
				temp = (double)(building[index] - building[i]) / (double)(index - i);
				// 이전의 기울기보다 크다면 보이는 건물
				// 기울기 갱신해주고 건물 개수 ++
				if (temp > g) {
					g = temp;
					cnt++;
				}
			}
		}
		// 건물 개수 반환
		return cnt;
	}
}