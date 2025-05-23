class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;

        // 1. 첫 번째 기지국 왼쪽 구간 커버 안 되는 구간 계산
        answer += getWidth(1, stations[0] - w - 1, 2 * w + 1);

        // 2. 기지국들 사이의 커버 안 되는 구간 계산
        for (int i = 1; i < stations.length; i++) {
            answer += getWidth(stations[i - 1] + w + 1, stations[i] - w - 1, 2 * w + 1);
        }

        // 3. 마지막 기지국 오른쪽 구간 계산
        answer += getWidth(stations[stations.length - 1] + w + 1, n, 2 * w + 1);

        return answer;
    }

    // [l, r] 구간을 w 범위로 커버할 때 필요한 최소 기지국 수를 계산하는 메서드
    int getWidth(int l, int r, int w) {
        int num = r - l + 1; // 커버해야 할 구간 길이
        if (num <= 0) return 0; // 커버할 구간이 없으면 기지국 필요 없음
        if (num % w == 0) return num / w; // 딱 나누어떨어지면 몫이 필요한 기지국 수
        return num / w + 1; // 나머지 남으면 하나 더 설치해야 함
    }
}
