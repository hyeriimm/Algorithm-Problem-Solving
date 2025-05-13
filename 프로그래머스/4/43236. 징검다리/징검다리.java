import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        
        Arrays.sort(rocks);
        int left = 1;
        int right = distance;
        int answer = 0;
        
        while (left <= right) {
            int mid = (left + right) / 2; // 최소 거리 후보
            int removed = 0;
            int prev = 0;
            
            for (int rock : rocks) {
                if (rock - prev < mid) {
                    removed++; // 간격 유지 못하면 제거
                }
                else {
                    prev = rock; // 바위 유지
                }
            }
            
            // 도착지점까지도 확인
            if (distance - prev < mid) removed++;
            
            // 중간 값 조정
            if (removed > n) {
                // 너무 많이 제거해야 한다면, 거리 좁히기
                right = mid - 1;
            }
            else {
                // 괜찮은 거리면, 정답 저장 후 거리 더 늘려보기
                answer = mid;
                left = mid + 1;
            }
        }
        
        return answer;
    }
}